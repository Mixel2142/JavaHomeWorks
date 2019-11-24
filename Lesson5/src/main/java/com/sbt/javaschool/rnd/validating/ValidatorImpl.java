package com.sbt.javaschool.rnd.validating;

import com.sbt.javaschool.rnd.exceptions.*;
import com.sbt.javaschool.rnd.server.Server;
import com.sbt.javaschool.rnd.server.ServerImpl;

/*
Проверяет на валидность данных и их существование.
 */
public class ValidatorImpl implements Validator {

    Server request = new ServerImpl();
    final Integer LENGHT_OF_PINCODE = 4;
    final Integer MAX_LENGHT_OF_ACCOUNTNAME = 10;


    public boolean isPasswordValid(String accaunt, String password) throws PinCodeIsNotValidExeption, PinCodeIsNotExistExeption {
        if (password.length() != LENGHT_OF_PINCODE)
            throw new PinCodeIsNotValidExeption("Длина пинкода должна быть равной " + LENGHT_OF_PINCODE + ".");

        if (!password.matches("[0-9]{4}"))//?? как засунуть константу LENGHT_OF_PINCODE в регулярное выражение
            throw new PinCodeIsNotValidExeption("Пинкод может содержать только цифры от 0 до 9.");

        return request.isPinCodeExist(accaunt, password);
    }


    public boolean isAccountsValid(String accountName) throws AccountIsNotValidExeption, AccountIsNotExistExeption {
        if (accountName.length() > MAX_LENGHT_OF_ACCOUNTNAME || accountName.length() == 0)
            throw new AccountIsNotValidExeption("Имя аккаунта должно быть больше нуля и меньше" + MAX_LENGHT_OF_ACCOUNTNAME + ".");

        request.isAccountExist(accountName);

        return true;
    }


    public boolean isAmountValid(String amount) throws AmountIsNotValidExeption {
        if(amount.isEmpty())
            throw new AmountIsNotValidExeption("Вы не ввели сумму денег.");

        if(amount.matches("^[0-9]+$"))
            throw new AmountIsNotValidExeption("Введи сумму цифрами.");

        if(Integer.parseInt(amount) < 0)
            throw new AmountIsNotValidExeption("Сумма должна быть положительной.");

        return true;
    }

}
