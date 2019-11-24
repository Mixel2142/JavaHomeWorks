package com.sbt.javaschool.rnd.server;

import com.sbt.javaschool.rnd.exceptions.*;


public interface Server {
    public boolean isPinCodeExist(String accaunt, String password) throws PinCodeIsNotExistExeption;

    public boolean isAccountExist(String data) throws AccountIsNotExistExeption;

    Integer checkBalance(String account); // Возвращает текущий баланс

    Integer withdrawMoney(String account, String amount) throws MoneyExeption;// Возвращает текущий баланс

    Integer putMoney(String account, String amount);// Возвращает текущий баланс
}
