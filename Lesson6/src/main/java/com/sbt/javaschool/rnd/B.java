package com.sbt.javaschool.rnd;

public class B extends C {
    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "wednesday";

    private String pubStrB;
    private String prStrB;

    public String getPubStrB() {
        return pubStrB;
    }

    public void setPubStrB(String pubStrB) {
        this.pubStrB = pubStrB;
    }

    private String getPrStrB() {
        return prStrB;
    }

    private void setPrStrB(String prStrB) {
        this.prStrB = prStrB;
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
            case "wednesday":
                return 3;
            default:
                return 0;
        }
    }
}
