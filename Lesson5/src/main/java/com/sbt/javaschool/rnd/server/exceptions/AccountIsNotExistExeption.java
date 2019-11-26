package com.sbt.javaschool.rnd.server.exceptions;

public class AccountIsNotExistExeption extends Exception {

    public AccountIsNotExistExeption() {
    }

    public AccountIsNotExistExeption(String message) {
        super(message);
    }

    public AccountIsNotExistExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountIsNotExistExeption(Throwable cause) {
        super(cause);
    }

    public AccountIsNotExistExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
