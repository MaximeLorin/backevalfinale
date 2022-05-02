package com.zenika.academy.barbajavas.backFinalProject.domain.model.questions;

public class QuestionTileToLongException extends Exception {
    private int errorCode;
    private String errorMessage;

    public QuestionTileToLongException(Throwable throwable) {
        super(throwable);
    }
    public QuestionTileToLongException(String  errorMessage,Throwable throwable) {
        super(errorMessage,throwable);
    }
    public QuestionTileToLongException(String  errorMessage) {
        super(errorMessage);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
