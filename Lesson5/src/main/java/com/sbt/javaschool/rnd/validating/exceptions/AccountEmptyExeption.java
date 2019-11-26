package com.sbt.javaschool.rnd.validating.exceptions;

public class AccountEmptyExeption extends Exception {
    public AccountEmptyExeption() {
    }

    public AccountEmptyExeption(String message) {
        super(message);
    }

    public AccountEmptyExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountEmptyExeption(Throwable cause) {
        super(cause);
    }

    public AccountEmptyExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
