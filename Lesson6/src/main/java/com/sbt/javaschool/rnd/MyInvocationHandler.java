package com.sbt.javaschool.rnd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private final Object delegate;

    public MyInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Started " + method.getName());
        Object result = method.invoke(delegate, args);
        System.out.println("Finished " + method.getName() + ". Result " + result);
        return result;
    }
}
