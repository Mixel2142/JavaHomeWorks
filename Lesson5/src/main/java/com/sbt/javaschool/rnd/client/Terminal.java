package com.sbt.javaschool.rnd.client;

import com.sbt.javaschool.rnd.exceptions.*;

public interface Terminal {

    boolean initSession(String accountName) ;

    boolean checkPinCode(String pinCode);


    boolean checkBalance();

    boolean withdrawMoney(String amount) ;

    boolean putMoney(String amount) ;

    void closeSession();
}
