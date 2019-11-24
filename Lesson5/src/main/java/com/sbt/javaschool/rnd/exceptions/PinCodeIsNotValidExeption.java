package com.sbt.javaschool.rnd.exceptions;

public class PinCodeIsNotValidExeption extends Exception {
    public PinCodeIsNotValidExeption() {
    }

    public PinCodeIsNotValidExeption(String message) {
        super(message);
    }

    public PinCodeIsNotValidExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public PinCodeIsNotValidExeption(Throwable cause) {
        super(cause);
    }

    public PinCodeIsNotValidExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
