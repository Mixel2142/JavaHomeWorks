package com.sbt.javaschool.rnd.client;

import com.sbt.javaschool.rnd.exceptions.*;

public interface Terminal {

    boolean initSession(String accountName);

    boolean checkPinCode(String pinCode);


    Integer checkBalance();

    void withdrawMoney(String amount);

    void putMoney(String amount);

    void closeSession();
}
