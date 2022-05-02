package com.zenika.academy.barbajavas.backFinalProject.web;

import com.zenika.academy.barbajavas.backFinalProject.domain.application.AnswerService;
import com.zenika.academy.barbajavas.backFinalProject.domain.application.QuestionService;
import com.zenika.academy.barbajavas.backFinalProject.domain.application.WordCounter;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.answers.Answer;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.answers.AnswerToLongException;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.answers.CreateAnswerDTO;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AnswerController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private WordCounter wordCounter;

    @PostMapping("/answers/{question_id}")
    ResponseEntity<Answer> createAnswer(@RequestBody CreateAnswerDTO answerDTO,@PathVariable String question_id) throws AnswerToLongException, UserNotFoundException {
        int nbOfWords=wordCounter.countWord(answerDTO.content());
        int wordsToRm=nbOfWords-20;

        Optional<Question> question = this.questionService.findQuestionById(question_id);

        if (nbOfWords>20){
            throw new AnswerToLongException("Votre contenu fait "+nbOfWords+" mots, vous avez "+wordsToRm+" mots en trop.");
        }
        if(question.isPresent()){
            Answer answer=answerService.newAnswer(answerDTO.content(),question.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(answer);
        }else {
            throw new UserNotFoundException("L'utilisateur n'existe pas !");
        }
    }
}
