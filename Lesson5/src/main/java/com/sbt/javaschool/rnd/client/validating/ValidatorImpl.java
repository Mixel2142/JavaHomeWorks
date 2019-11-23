package com.sbt.javaschool.rnd.client.validating;

import com.sbt.javaschool.rnd.server.Server;
import com.sbt.javaschool.rnd.server.ServerImpl;

/*
Проверяет на валидность данных и их существование.
 */
public class ValidatorImpl implements Validator {

    Server request = new ServerImpl();
    final Integer LENGHT_OF_PINCODE = 4;
    final Integer MAX_LENGHT_OF_ACCOUNTNAME = 10;

    @Override
    public boolean isPasswordValid(String password) {
        if (password.length() == LENGHT_OF_PINCODE) {
          if(password.matches("[0-9]{4}" )) {
              return request.isPinCodeExist(password);
          }
            //throw new PinCodeContentExeption;
            return false;
        }
        //throw new PinCodeLengthExeption;
        return false;
    }

    @Override
    public boolean isAccountsValid(String accountName) {
        if(accountName.length() < MAX_LENGHT_OF_ACCOUNTNAME && accountName.length() != 0) {
            if (request.isAccountExist(accountName)) {
                return true;
            }
            //throw new AccountIsNotExist;
            return false;
        }
        //throw new AccountLengthExeption;
        return false;
    }

}
