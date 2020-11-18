package com.pe.alicorp.core.coevaluation.model;

public class EvaluationResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EvaluationResponse(String message) {
        super();
        this.message = message;
    }

    public EvaluationResponse() {
        super();
    }
}