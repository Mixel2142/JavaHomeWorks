package com.sbt.javaschool.rnd.server;

import com.sbt.javaschool.rnd.validating.exceptions.*;
import com.sbt.javaschool.rnd.server.exceptions.AccountIsNotExistExeption;
import com.sbt.javaschool.rnd.server.exceptions.PinCodeIsNotExistExeption;


public interface Server {
    public boolean isPinCodeExist(String accaunt, String password) throws PinCodeIsNotExistExeption;

    public boolean isAccountExist(String data) throws AccountIsNotExistExeption;

    Integer checkBalance(String account);

    Integer withdrawMoney(String account, String amount) throws MoneyExeption;

    Integer putMoney(String account, String amount);
}
