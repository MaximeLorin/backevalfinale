package com.zenika.academy.barbajavas.backFinalProject.web;

import com.zenika.academy.barbajavas.backFinalProject.domain.application.QuestionService;
import com.zenika.academy.barbajavas.backFinalProject.domain.application.WordCounter;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.CreateQuestionDTO;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Language;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.QuestionTileToLongException;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.User;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.UserNotFoundException;
import com.zenika.academy.barbajavas.backFinalProject.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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
        boolean confirmLanguage=false;
        Optional<User> user = this.userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        for (Language lang: Language.values()) {
            if(Objects.equals(questionDTO.language(), lang.toString())){
                confirmLanguage=true;
            }
        }

        if (nbOfWords>20 ){
            throw new QuestionTileToLongException("Votre titre fait "+nbOfWords+" mots, vous avez "+wordsToRm+" mots en trop.");
        }

        if(user.isPresent() && confirmLanguage){
            Question question=questionService.newQuestion(questionDTO.title(),questionDTO.content(), questionDTO.language(), user.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(question);
        }else {
            throw new UserNotFoundException("L'utilisateur n'existe pas !");
        }
    }

    @GetMapping("/questions")
    List<Question> getEveryQuestions(){
        return questionService.getAllQuestionsOrdered();
    }

    @GetMapping("/questions/search")
    List<Question> getByTitlePart(@RequestParam("title") String titlePart){
        return questionService.getQuestionsByPart(titlePart);
    }

    @GetMapping("/questions/{language}")
    List<Question> getQuestionsByLanguage(@PathVariable String language){
        return questionService.getByLanguage(language);
    }

    @GetMapping("/questions/user")
    List<Question> getQuestionsByUserId(@RequestParam("user_id") String user_id){
        return questionService.getByUserId(user_id);
    }

    @GetMapping("/no-answer")
    List<Question> getQuestionsWithoutAnswers(){
        System.out.println("toto");
        return questionService.getWhereNoAnswer();
    }
}
