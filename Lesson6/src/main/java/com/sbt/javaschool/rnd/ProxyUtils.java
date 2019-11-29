package com.sbt.javaschool.rnd;

import java.lang.reflect.Proxy;

public class ProxyUtils {
    public static <E> E makeCached(E instance) {
        Class instanceClass = instance.getClass();
        return (E) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                instanceClass.getInterfaces(),
                new CacheProxy(instance));
    }
}
