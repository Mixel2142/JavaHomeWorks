package com.sbt.javaschool.rnd.exceptions;

public class AccountIsNotValidExeption extends Exception {
    public AccountIsNotValidExeption() {
    }

    public AccountIsNotValidExeption(String message) {
        super(message);
    }

    public AccountIsNotValidExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountIsNotValidExeption(Throwable cause) {
        super(cause);
    }

    public AccountIsNotValidExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
