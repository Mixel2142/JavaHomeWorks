package com.sbt.javaschool.rnd.validating.exceptions;

public class MoneyExeption extends Exception {
    public MoneyExeption() {
    }

    public MoneyExeption(String message) {
        super(message);
    }

    public MoneyExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public MoneyExeption(Throwable cause) {
        super(cause);
    }

    public MoneyExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
