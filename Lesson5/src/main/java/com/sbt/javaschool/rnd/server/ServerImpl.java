package com.sbt.javaschool.rnd.server;

import com.sbt.javaschool.rnd.exceptions.*;
import com.sbt.javaschool.rnd.server.Server;

import java.util.HashMap;
import java.util.Map;

public class ServerImpl implements Server {
    Map<String, Integer> dataBase = new HashMap<>();

    {
        dataBase.put("Ivan", 1234);
        dataBase.put("Masha", 4321);
        dataBase.put("Roma", 1997);
    }

    @Override
    public boolean isPinCodeExist(String accaunt,String password) throws PinCodeIsNotExistExeption {

        if (dataBase.get(accaunt) == Integer.parseInt(password)) {
            return true;
        }
        throw new PinCodeIsNotExistExeption("Пароль не верный.");
    }

    @Override
    public boolean isAccountExist(String data) throws AccountIsNotExistExeption {
        if (dataBase.containsKey(data)) {
            return true;
        }
        throw new AccountIsNotExistExeption("База данных не содержит такого аккаунта.");
    }
}
