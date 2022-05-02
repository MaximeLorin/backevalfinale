package com.zenika.academy.barbajavas.backFinalProject.web;

import com.zenika.academy.barbajavas.backFinalProject.domain.application.QuestionService;
import com.zenika.academy.barbajavas.backFinalProject.domain.application.WordCounter;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.CreateQuestionDTO;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.QuestionTileToLongException;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.User;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.UserNotFoundException;
import com.zenika.academy.barbajavas.backFinalProject.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WordCounter wordCounter;

    @PostMapping("/questions")
    ResponseEntity<Question> createQuestion(@RequestBody CreateQuestionDTO questionDTO) throws QuestionTileToLongException, UserNotFoundException {
        int nbOfWords=wordCounter.countWord(questionDTO.title());
        int wordsToRm=nbOfWords-20;

        Optional<User> user = this.userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        if (nbOfWords>20){
            throw new QuestionTileToLongException("Votre titre fait "+nbOfWords+" mots, vous avez "+wordsToRm+" mots en trop.");
        }
        if(user.isPresent()){

            Question question=questionService.newQuestion(questionDTO.title(),questionDTO.content(),user.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(question);
        }else {
            throw new UserNotFoundException("L'utilisateur n'existe pas !");
        }
    }
}
