package com.sbt.javaschool.rnd.server;

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
    public boolean isPinCodeExist(String data) {
        if (dataBase.containsValue(Integer.parseInt(data))) {
            return true;
        }
        //throw new PinCodeIsNotExist()
        return false;
    }

    @Override
    public boolean isAccountExist(String data) {
        if (dataBase.containsKey(data)) {
            return true;
        }
        //throw new AccountIsNotExist()
        return false;
    }
}
