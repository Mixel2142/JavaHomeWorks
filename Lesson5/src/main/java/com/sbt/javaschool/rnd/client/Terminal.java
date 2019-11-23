package com.sbt.javaschool.rnd.client;

public interface Terminal {

    void doWelcomeAccount();

    void doWelcomePinCode();

    void showActions();


    boolean initSession(String accountName);

    boolean checkPinCode(String pinCode);


    void checkBalance();

    void withdrawMoney(Integer amount);

    void putMoney();

}
