package com.sbt.javaschool.rnd.client;

import com.sbt.javaschool.rnd.validating.exceptions.*;
import com.sbt.javaschool.rnd.server.exceptions.AccountIsNotExistExeption;
import com.sbt.javaschool.rnd.server.exceptions.PinCodeIsNotExistExeption;
import com.sbt.javaschool.rnd.validating.*;
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
            server.isAccountExist(accountName);
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
    public void closeSession() {
        accountName = "";
        accountPassword = "";
        numberOfUnsuccessfulAttemptsToEnterPinCode = 0;
    }

    @Override
    public Integer checkBalance() {
        if (checkAccountAcces()) {
            return server.checkBalance(accountName);
        }
        return 0;
    }

    @Override
    public void putMoney(String amount) {
        if (checkAccountAcces())
            try {
                validator.isAmountValid(amount);
                server.putMoney(accountName, amount);
            } catch (AmountIsNotValidExeption e) {
                System.err.println(e.getMessage());
            }
    }

    @Override
    public void withdrawMoney(String amount) {
        if (checkAccountAcces())
            try {
                validator.isAmountValid(amount);
                server.withdrawMoney(accountName, amount);
            } catch (MoneyExeption e) {
                System.err.println(e.getMessage());
            } catch (AmountIsNotValidExeption e) {
                System.err.println(e.getMessage());
            }
    }

    @Override
    public boolean checkPinCode(String pinCode) {
        try {

            if (numberOfUnsuccessfulAttemptsToEnterPinCode == 3 || lockState) {
                lockAccountOnFiveSec();
                throw new AccountIsLockedException("Аккаунт заблокирован на " + lockedTimeSec + " секунд из-за трёх попыток ввода не правильного пароля.");
            }

            if (validator.isPasswordValid(accountName, pinCode) && server.isPinCodeExist(accountName, pinCode)) {
                accountPassword = pinCode;
                numberOfUnsuccessfulAttemptsToEnterPinCode = 0;
                return true;
            }

        } catch (PinCodeIsNotValidExeption | PinCodeIsNotExistExeption e) {
            System.err.println(e.getMessage());
            numberOfUnsuccessfulAttemptsToEnterPinCode++;
        } catch (AccountIsLockedException e) {
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
