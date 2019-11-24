package com.sbt.javaschool.rnd.server;

import com.sbt.javaschool.rnd.exceptions.*;


public interface Server {
    public boolean isPinCodeExist(String accaunt,String password) throws PinCodeIsNotExistExeption;

    public boolean isAccountExist(String data) throws AccountIsNotExistExeption;
}
