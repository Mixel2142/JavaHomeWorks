package com.sbt.jvschool.rnd.services;

import com.sbt.jvschool.rnd.proxy.Cache;

public interface Service {
    @Cache
    double doHardWorkOne(String nameWork, Integer hours);

    @Cache
    double doHardWorkTwo(String nameWork, Integer hours);

    @Cache
    double doHardWorkThree(String nameWork, Integer hours);
}
