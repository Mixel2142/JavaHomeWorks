package com.sbt.javaschool.rnd.validating.exceptions;

public class AccountIsLockedException extends Exception {
    public AccountIsLockedException() {
    }

    public AccountIsLockedException(String message) {
        super(message);
    }

    public AccountIsLockedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountIsLockedException(Throwable cause) {
        super(cause);
    }

    public AccountIsLockedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
