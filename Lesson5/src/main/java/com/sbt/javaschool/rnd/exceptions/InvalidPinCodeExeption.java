package com.sbt.javaschool.rnd.exceptions;

public class InvalidPinCodeExeption extends Exception {
    public InvalidPinCodeExeption() {
    }

    public InvalidPinCodeExeption(String message) {
        super(message);
    }

    public InvalidPinCodeExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPinCodeExeption(Throwable cause) {
        super(cause);
    }

    public InvalidPinCodeExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
