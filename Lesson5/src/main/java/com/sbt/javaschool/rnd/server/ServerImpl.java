package com.sbt.javaschool.rnd.server;

import com.sbt.javaschool.rnd.exceptions.*;
import com.sbt.javaschool.rnd.server.Server;
import java.util.HashMap;

import java.util.Map;

public class ServerImpl implements Server {
    Map<String, Account> dataBase = new HashMap();

    {
        String id = "Ivan";
        dataBase.put(id, new Account("Ivan", 1234, 1000));
        id = "Masha";
        dataBase.put(id, new Account("Masha", 4321, 2000));
        id = "Roman";
        dataBase.put(id, new Account("Roman", 1997, 3000));
    }

    @Override
    public boolean isPinCodeExist(String account, String password) throws PinCodeIsNotExistExeption {

        if (dataBase.get(account).getPassword() == Integer.parseInt(password)) {
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

    @Override
    public Integer checkBalance(String account) {
        return dataBase.get(account).getMoney();
    }

    @Override
    public Integer withdrawMoney(String account, String amount) throws MoneyExeption {
        Integer currentMoney = dataBase.get(account).getMoney() - Integer.parseInt(amount);
        if (currentMoney < 0)
            throw new MoneyExeption("На счёта не достаточно средств:" + dataBase.get(account).getMoney()+".");
        dataBase.get(account).setMoney(currentMoney);
        return currentMoney;
    }

    @Override
    public Integer putMoney(String account, String amount) {
        Integer currentMoney = dataBase.get(account).getMoney() + Integer.parseInt(amount);
        dataBase.get(account).setMoney(currentMoney);
        return currentMoney;
    }
}
