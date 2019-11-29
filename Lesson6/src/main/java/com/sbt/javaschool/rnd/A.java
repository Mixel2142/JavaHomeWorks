package com.sbt.javaschool.rnd;

public class A extends B implements AlphabetSuper {
    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "tuesday";

    private String pubStrA;
    private String prStrA;

    public String getPubStrA() {
        return pubStrA;
    }

    public void setPubStrB(String pubStrA) {
        this.pubStrA = pubStrA;
    }

    private String getPrStrA() {
        return prStrA;
    }

    private void setPrStrA(String prStrA) {
        this.prStrA = prStrA;
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
            case "tuesday":
                return 2;
            default:
                return 0;
        }
    }
}
