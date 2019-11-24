package com.sbt.javaschool.rnd.validating;

import org.junit.Test;
import static org.junit.Assert.*;
import com.sbt.javaschool.rnd.validating.*;

public class ValidatorImplTest {

    Validator validator = new ValidatorImpl();
    @Test
    public void isPasswordValid() {

        String password = "1234";

        assertTrue(validator.isPasswordValid("Ivan",password));
        // добавить мок! для return request.isPinCodeExist(accaunt, password)
        // что-то сделать с exeption который кидает validator
    }

    @Test
    public void isAccountsValid() {
    }

    @Test
    public void isAmountValid() {
    }

    @Test
    public void testIsPasswordValid() {
    }

    @Test
    public void testIsAccountsValid() {
    }


}