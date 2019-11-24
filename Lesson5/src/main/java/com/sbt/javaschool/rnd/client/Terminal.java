package com.sbt.javaschool.rnd.client;

import com.sbt.javaschool.rnd.exceptions.*;

public interface Terminal {

    boolean initSession(String accountName);

    boolean checkPinCode(String pinCode);


    Integer checkBalance();

    Integer withdrawMoney(String amount);

    Integer putMoney(String amount);

    void closeSession();
}
