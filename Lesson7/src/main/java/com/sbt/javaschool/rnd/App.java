package com.sbt.javaschool.rnd;

import com.sbt.javaschool.rnd.DynamicClassOverloader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] argv) throws Exception {
        ClassLoader loader;
        for (; ; ) {
            loader = new DynamicClassOverloader(new String[]{"E:\\projects\\IntelliJIDEA\\JavaHomeWorks\\Lesson7\\Plugins\\target\\classes\\"});
            // текущий каталог "." будет единственным
            // каталогом поиска
            Class clazz = Class.forName("HelloPlugin", true, loader);
            Object object = clazz.newInstance();
            System.out.println(object);
            new BufferedReader(
                    new InputStreamReader(System.in)).readLine();
        }
    }
}
