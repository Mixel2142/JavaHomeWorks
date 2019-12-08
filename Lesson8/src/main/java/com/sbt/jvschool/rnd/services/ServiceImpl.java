package com.sbt.jvschool.rnd.services;

public class ServiceImpl implements Service {
    @Override
    public double doHardWorkOne(String nameWork, Integer hours) {
        return doSameWork(nameWork, hours);
    }

    @Override
    public double doHardWorkTwo(String nameWork, Integer hours) {
        return doSameWork(nameWork, hours);
    }

    @Override
    public double doHardWorkThree(String nameWork, Integer hours) {
        return doSameWork(nameWork, hours);
    }

    private double doSameWork(String nameWork, Integer hours) {

        double ret = 100_905 * hours;
        for (int i = 0; i < hours; i++) {
            ret /= i;
        }
        return ret;
    }
}
