package com.medical.common.exception;

public class DataInconsistencyException extends Exception {
    private static final long serialVersionUID = -4215320555579847226L;

    public DataInconsistencyException(String message) {
        super(message);
    }

    public DataInconsistencyException(String message, Throwable cause) {
        super(message, cause);
    }
}
