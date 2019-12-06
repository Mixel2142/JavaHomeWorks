package com.jvschool.rnd;

import com.jvschool.rnd.api.Plugin;

public class MyFirstPlugin implements Plugin {

    @Override
    public void run() {
        System.out.println("MyFirstPlugin: RUN");
    }

    @Override
    public void close() {
        System.out.println("MyFirstPlugin: CLOSE");
    }
}
