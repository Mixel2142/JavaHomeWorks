package com.sbt.javaschool.rnd.validating;

import com.sbt.javaschool.rnd.validating.exceptions.*;
import com.sbt.javaschool.rnd.server.exceptions.AccountIsNotExistExeption;
import com.sbt.javaschool.rnd.server.exceptions.PinCodeIsNotExistExeption;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorImplTest {

    @Test
    public void isPasswordValid_EmptryPin() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isPasswordValid("","");
        } catch (PinCodeIsNotValidExeption e) {
          assertEquals("Длина пинкода должна быть равной 4.",e.getMessage());
          return;
        }

        assertTrue(false);
    }

    @Test
    public void isPasswordValid_PinIsNotDigits() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isPasswordValid("","asds");
        } catch (PinCodeIsNotValidExeption e) {
            assertEquals("Пинкод может содержать только цифры от 0 до 9.",e.getMessage());
            return;
        } assertTrue(false);
    }

    @Test
    public void isPasswordValid_PinIsSigns1() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isPasswordValid("","----");
        } catch (PinCodeIsNotValidExeption e) {
            assertEquals("Пинкод может содержать только цифры от 0 до 9.",e.getMessage());
            return;
        } assertTrue(false);
    }

    @Test
    public void isPasswordValid_PinIsSigns2() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isPasswordValid("","++++");
        } catch (PinCodeIsNotValidExeption e) {
            assertEquals("Пинкод может содержать только цифры от 0 до 9.",e.getMessage());
            return;
        } assertTrue(false);
    }

    @Test
    public void isPasswordValid_PinIsSigns3() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isPasswordValid("","+123");
        } catch (PinCodeIsNotValidExeption e) {
            assertEquals("Пинкод может содержать только цифры от 0 до 9.",e.getMessage());
            return;
        } assertTrue(false);
    }

    @Test
    public void isPasswordValid_PinIsSigns4() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isPasswordValid("","-123");
        } catch (PinCodeIsNotValidExeption e) {
            assertEquals("Пинкод может содержать только цифры от 0 до 9.",e.getMessage());
            return;
        } assertTrue(false);
    }

    @Test
    public void isPasswordValid_PinIsSigns5() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isPasswordValid("","1-34");
        } catch (PinCodeIsNotValidExeption e) {
            assertEquals("Пинкод может содержать только цифры от 0 до 9.",e.getMessage());
            return;
        } assertTrue(false);
    }

    @Test
    public void isAccountsValid1() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isAccountsValid("");
        } catch (AccountIsNotValidExeption e) {
            assertEquals("Длина имени аккаунта должно быть больше нуля и меньше 10.",e.getMessage());
            return;
        }

        assertTrue(false);
    }

    @Test
    public void isAccountsValid2() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isAccountsValid("1234567Ivan890123");
        } catch (AccountIsNotValidExeption e) {
            assertEquals("Длина имени аккаунта должно быть больше нуля и меньше 10.",e.getMessage());
            return;
        }

        assertTrue(false);
    }

    @Test
    public void isAmountValid1() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isAmountValid("");
        } catch (AmountIsNotValidExeption e) {
            assertEquals("Вы ничего не ввели.",e.getMessage());
            return;
        }

        assertTrue(false);
    }

    @Test
    public void isAmountValid2() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isAmountValid("-12323");
        } catch (AmountIsNotValidExeption e) {
            assertEquals("Сумма должна быть положительной.",e.getMessage());
            return;
        }

        assertTrue(false);
    }

    @Test
    public void isAmountValid3() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isAmountValid("-+12323");
        } catch (AmountIsNotValidExeption e) {
            assertEquals("Вы ввели не число.",e.getMessage());
            return;
        }

        assertTrue(false);
    }

    @Test
    public void isAmountValid4() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isAmountValid("---");
        } catch (AmountIsNotValidExeption e) {
            assertEquals("Вы ввели не число.",e.getMessage());
            return;
        }

        assertTrue(false);
    }

    @Test
    public void isAmountValid5() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isAmountValid("-");
        } catch (AmountIsNotValidExeption e) {
            assertEquals("Вы ввели не число.",e.getMessage());
            return;
        }

        assertTrue(false);
    }

    @Test
    public void isAmountValid6() {
        Validator validator = new ValidatorImpl();
        try {
            validator.isAmountValid("150");
        } catch (AmountIsNotValidExeption e) {
            assertEquals("Сумма должна быть кратна 100-м.",e.getMessage());
            return;
        }

        assertTrue(false);
    }
}