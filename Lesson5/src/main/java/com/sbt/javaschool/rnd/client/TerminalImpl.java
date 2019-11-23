package com.sbt.javaschool.rnd.client;

import com.sbt.javaschool.rnd.validating.ValidatorImpl;
import com.sbt.javaschool.rnd.validating.Validator;
import com.sbt.javaschool.rnd.server.Server;
import com.sbt.javaschool.rnd.server.ServerImpl;

public class TerminalImpl implements Terminal {
    private final Server server;
    private final Validator validator;

    {
        server = new ServerImpl();
        validator = new ValidatorImpl();
    }

    private String accountName = "";
    private boolean accountAcces = false;

    @Override
    public boolean initSession(String accountName) {
        if (validator.isAccountsValid(accountName)) {
            this.accountName = accountName;
            this.doWelcomeAccount();
            return true;
        }
        // throw neц AccountNotExist;
        return false;
    }

    @Override
    public void doWelcomeAccount() {
        if (accountName.isEmpty()) {
            System.out.println("Введите имя аккаунта.");
            System.out.print("Ввод:> ");
        } else {
            System.out.println("Добро пожаловать," + accountName + "!");
        }
    }

    @Override
    public void doWelcomePinCode() {
        System.out.println(accountName + ", введите пинкод состоящий из 4 цифр.");
        System.out.print("Ввод:> ");
    }

    @Override
    public void checkBalance() {
        if (accountAcces) {

            return;
        }
        // throw new AccountAccesExeption;
    }

    @Override
    public void putMoney(String amount) {
        if (accountAcces) {

            return;
        }
        // throw new AccountAccesExeption;
    }

    @Override
    public void closeSession() {
        accountName = "";
        accountAcces = false;
    }

    @Override
    public void withdrawMoney(String amount) {
        if (accountAcces) {

            return;
        }
        // throw new AccountAccesExeption;
    }

    @Override
    public boolean checkPinCode(String pinCode) {
        if (validator.isPasswordValid(pinCode)) {
            accountAcces = true;
            return true;
        }
        // throw new InvalidPinCode;
        accountAcces = false;
        return false;
    }

    @Override
    public void showActions() {
        System.out.println("Введите код одного из действий:");
        System.out.println("(0): Проверить баланс.");
        System.out.println("(1): Пополнить баланс.");
        System.out.println("(2): Снять деньги.");
        System.out.println("(3): Перевести на другой аккаунт.");
        System.out.println("(4): Покинуть аккаунт.");
        System.out.print("Ввод:> ");
    }


}
