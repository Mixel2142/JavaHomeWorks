package com.sbt.javaschool.rnd;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class C implements AlphabetWeek, AlphabetNumber {
    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";
    public static final String THURSDAY = "Thursday";

    private String pubStrC;
    private String prStrC;

    public String getPubStrC() {
        return pubStrC;
    }

    public void setPubStrC(String pubStrC) {
        this.pubStrC = pubStrC;
    }

    private String getPrStrC() {
        return prStrC;
    }

    private void setPrStrC(String prStrC) {
        this.prStrC = prStrC;
    }

    @Override
    public String getAllDays() throws IllegalAccessException {
        return AlphabetUtils.getAllDays(this.getClass().getDeclaredFields());
    }

    @Override
    public Integer getNumberDay(String day) {
        switch (day) {
            case "MONDAY":
                return 1;
            case "TUESDAY":
                return 2;
            case "WEDNESDAY":
                return 3;
            case "Thursday":
                return 4;
            default:
                return 0;
        }
    }

}