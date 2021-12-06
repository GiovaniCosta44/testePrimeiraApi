package com.giovani.teste.domain.exception;

public class NegocioException extends RuntimeException {

    private static final long serialVersionUID = -3915684684154185158L;

    public NegocioException(String message) {
        super(message);
    }
}
