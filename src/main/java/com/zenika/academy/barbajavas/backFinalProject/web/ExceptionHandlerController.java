package com.zenika.academy.barbajavas.backFinalProject.web;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.QuestionTileToLongException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(QuestionTileToLongException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public QuestionTileToLongException handleQuestionException(QuestionTileToLongException qtle){
        return qtle;
    }
}
