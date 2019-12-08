package com.sbt.jvschool.rnd.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CacheProxy implements InvocationHandler {
    private Object delegate;
    private Object[] cacheArgs = null;
    private Object cacheResult = null;

    //Settings Cache
    /*
    *Эти настройки перебивают значения, которые были заданы в анатации к методу
     */
    private String pluginRootDirectory;
    CacheTypeState cacheType;


    private CacheProxy(Object delegate) {
        this.delegate = delegate;
    }



    public static <E> E cache(E instance) {
        Class instanceClass = instance.getClass();
        return (E) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                instanceClass.getInterfaces(),
                new CacheProxy(instance));
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
