package com.medical.common.exception;

public class NonExistingResourceException extends Exception {

    private static final long serialVersionUID = -6785942216665749149L;

    public NonExistingResourceException(String message) {
        super(message);
    }
}
