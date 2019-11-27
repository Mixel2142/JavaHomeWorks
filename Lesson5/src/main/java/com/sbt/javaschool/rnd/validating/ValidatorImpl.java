package com.sbt.javaschool.rnd.validating;

import com.sbt.javaschool.rnd.validating.exceptions.*;
import com.sbt.javaschool.rnd.server.Server;
import com.sbt.javaschool.rnd.server.ServerImpl;

public class ValidatorImpl implements Validator {

    Server request = new ServerImpl();
    final Integer LENGHT_OF_PINCODE = 4;
    final Integer MAX_LENGHT_OF_ACCOUNTNAME = 10;

    @Override
    public boolean isPasswordValid(String accaunt, String password) throws PinCodeIsNotValidExeption {
        if (password.length() != LENGHT_OF_PINCODE)
            throw new PinCodeIsNotValidExeption("Длина пинкода должна быть равной " + LENGHT_OF_PINCODE + ".");

        if (!password.matches("[0-9]{4}"))
            throw new PinCodeIsNotValidExeption("Пинкод может содержать только цифры от 0 до 9.");

        return true;
    }

    @Override
    public boolean isAccountsValid(String accountName) throws AccountIsNotValidExeption {
        if (accountName.length() > MAX_LENGHT_OF_ACCOUNTNAME || accountName.length() == 0)
            throw new AccountIsNotValidExeption("Длина имени аккаунта должно быть больше нуля и меньше " + MAX_LENGHT_OF_ACCOUNTNAME + ".");

        return true;
    }

    @Override
    public boolean isAmountValid(String amount) throws AmountIsNotValidExeption {
        if (amount.isEmpty())
            throw new AmountIsNotValidExeption("Вы ничего не ввели.");

        Integer num;
        try {
            num = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new AmountIsNotValidExeption("Вы ввели не число.");
        }

        if (num < 0)
            throw new AmountIsNotValidExeption("Сумма должна быть положительной.");

        if (num%100 > 0)
            throw new AmountIsNotValidExeption("Сумма должна быть кратна 100-м.");

        return true;
    }

}
