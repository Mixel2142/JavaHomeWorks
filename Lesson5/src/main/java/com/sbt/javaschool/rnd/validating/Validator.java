package com.sbt.javaschool.rnd.validating;

import com.sbt.javaschool.rnd.validating.exceptions.*;
import com.sbt.javaschool.rnd.server.exceptions.AccountIsNotExistExeption;
import com.sbt.javaschool.rnd.server.exceptions.PinCodeIsNotExistExeption;


public interface Validator {
    public boolean isPasswordValid(String accaunt, String password) throws PinCodeIsNotValidExeption;

    public boolean isAccountsValid(String accountName) throws AccountIsNotValidExeption;

    public boolean isAmountValid(String amount) throws AmountIsNotValidExeption;
}
