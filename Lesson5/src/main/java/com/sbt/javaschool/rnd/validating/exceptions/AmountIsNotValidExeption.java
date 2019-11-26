package com.sbt.javaschool.rnd.validating.exceptions;

public class AmountIsNotValidExeption extends Exception {
    public AmountIsNotValidExeption() {
    }

    public AmountIsNotValidExeption(String message) {
        super(message);
    }

    public AmountIsNotValidExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountIsNotValidExeption(Throwable cause) {
        super(cause);
    }

    public AmountIsNotValidExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
