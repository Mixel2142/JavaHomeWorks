package com.sbt.javaschool.rnd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CacheProxy implements InvocationHandler {
    private final Object delegate;
    Object[] cacheArgs = null;
    Object cacheResult = null;

    public CacheProxy(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getAnnotation(Cache.class) != null)
            if (!isArgsEqual(args)) {
                System.out.println("Нету, Кеша!");
                cacheResult = method.invoke(delegate, args);
                cacheArgs = args;
            }

        return cacheResult;
    }

    private boolean isArgsEqual(Object[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (!args[i].equals(cacheArgs[i])) return false;
            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

}
