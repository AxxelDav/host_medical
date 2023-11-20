package com.medical.common.exception;

public class IllegalArgumentException extends Exception {

    private static final long serialVersionUID = -7052146887561361826L;
    private String error;
    private final String errorCause;

    public IllegalArgumentException(String message, String error, String cause) {
        super(message);
        this.error = error;
        this.errorCause = cause;
    }

    public IllegalArgumentException(String message, String error) {
        super(message);
        this.error = error;
        this.errorCause = null;
    }

    public IllegalArgumentException(String message) {
        super(message);
        this.errorCause = null;
    }

    public String getError() {
        return this.error;
    }

    public String getErrorCause() {
        return this.errorCause;
    }
}
