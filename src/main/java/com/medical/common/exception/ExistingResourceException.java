package com.medical.common.exception;

public class ExistingResourceException extends Exception {
    private static final long serialVersionUID = -6350184990013394507L;
    private final String resource;
    private final String error;

    public ExistingResourceException(String message, String resource, String error) {
        super(message);
        this.resource = resource;
        this.error = error;
    }

    public String getResource() {
        return this.resource;
    }

    public String getError() {
        return this.error;
    }
}
