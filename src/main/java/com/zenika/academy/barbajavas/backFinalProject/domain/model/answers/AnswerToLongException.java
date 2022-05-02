package com.zenika.academy.barbajavas.backFinalProject.domain.model.answers;

public class AnswerToLongException extends Exception{
    public AnswerToLongException() {
    }

    public AnswerToLongException(String message) {
        super(message);
    }

    public AnswerToLongException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnswerToLongException(Throwable cause) {
        super(cause);
    }
}
