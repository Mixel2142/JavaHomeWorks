package com.sbt.javaschool.rnd.client;

import com.sbt.javaschool.rnd.exceptions.*;
import com.sbt.javaschool.rnd.validating.ValidatorImpl;
import com.sbt.javaschool.rnd.validating.Validator;
import com.sbt.javaschool.rnd.server.Server;
import com.sbt.javaschool.rnd.server.ServerImpl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TerminalImpl implements Terminal {
    private final Server server = new ServerImpl();
    private final Validator validator = new ValidatorImpl();

    private String accountName = "";
    private String accountPassword = "";
    private Integer numberOfUnsuccessfulAttemptsToEnterPinCode = 0;
    private static boolean lockState = false;
    private Integer lockedTimeSec = 5;

    @Override
    public boolean initSession(String accountName) {
        try {
            validator.isAccountsValid(accountName);
            this.accountName = accountName;
            return true;
        } catch (AccountIsNotValidExeption e) {
            System.err.println(e.getMessage());
            return false;
        } catch (AccountIsNotExistExeption e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean checkBalance() {
        if (checkAccountAcces()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean putMoney(String amount) {
        if (checkAccountAcces()) {
            return true;
        }
        return false;
    }

    @Override
    public void closeSession() {
        accountName = "";
        accountPassword = "";
        numberOfUnsuccessfulAttemptsToEnterPinCode = 0;
    }

    @Override
    public boolean withdrawMoney(String amount) {
        if (checkAccountAcces()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPinCode(String pinCode) {
        try {
            if (lockState)
                throw new AccountIsLockedException("Аккаунт заблокирован на" + lockedTimeSec + "секунд из-за трёх попыток ввода не правильного пароля.");


            if(validator.isPasswordValid(accountName,pinCode)) {
                accountPassword = pinCode;
                numberOfUnsuccessfulAttemptsToEnterPinCode = 0;
                return true;
            }

            numberOfUnsuccessfulAttemptsToEnterPinCode++;
            if (numberOfUnsuccessfulAttemptsToEnterPinCode == 3) {
                lockAccountOnFiveSec();
                throw new AccountIsLockedException("Аккаунт заблокирован на" + lockedTimeSec + "секунд из-за трёх попыток ввода не правильного пароля.");
            }
        } catch (PinCodeIsNotValidExeption|AccountIsLockedException|PinCodeIsNotExistExeption e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    private void lockAccountOnFiveSec() {
        lockState = true;
        numberOfUnsuccessfulAttemptsToEnterPinCode = 0;
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(new Runnable() {
            @Override
            public void run() {
                TerminalImpl.unLockAccount();
            }
        }, lockedTimeSec, TimeUnit.SECONDS);
    }

    private static void unLockAccount() {
        lockState = false;
    }

    private boolean checkAccountAcces() {
        try {
            if (accountName.isEmpty())
                throw new AccountIsNotExistExeption("Попытка вызова метода без инициализации аккаунта именем!");

            if (accountPassword.isEmpty())
                throw new AccountEmptyExeption("Попытка вызова метода без ввода пароля для аккаунта!");

            if (lockState)
                throw new AccountIsLockedException("Попытка вызова метода для заблокированного аккаунта!");

            return true;
        } catch (AccountIsNotExistExeption | AccountEmptyExeption | AccountIsLockedException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

}
