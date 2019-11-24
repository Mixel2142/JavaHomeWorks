package com.sbt.javaschool.rnd.validating;

import com.sbt.javaschool.rnd.exceptions.*;


public interface Validator {
    public boolean isPasswordValid(String accaunt, String password) throws PinCodeIsNotValidExeption, PinCodeIsNotExistExeption;

    public boolean isAccountsValid(String accountName) throws AccountIsNotValidExeption, AccountIsNotExistExeption;

}
