package com.sbt.javaschool.rnd.exceptions;

public class PinCodeIsNotExistExeption extends Exception {
    public PinCodeIsNotExistExeption() {
    }

    public PinCodeIsNotExistExeption(String message) {
        super(message);
    }

    public PinCodeIsNotExistExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public PinCodeIsNotExistExeption(Throwable cause) {
        super(cause);
    }

    public PinCodeIsNotExistExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
