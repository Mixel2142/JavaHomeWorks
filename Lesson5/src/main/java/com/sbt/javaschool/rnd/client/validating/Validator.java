package com.sbt.javaschool.rnd.client.validating;

public interface Validator {
    public boolean isPasswordValid(String password);
    public boolean isAccountsValid(String accountName);

}
