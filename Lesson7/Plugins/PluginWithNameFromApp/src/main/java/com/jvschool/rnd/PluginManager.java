package com.jvschool.rnd;

import com.jvschool.rnd.api.Plugin;

public class PluginManager implements Plugin {

    @Override
    public void run() {
        System.out.println("PluginManager: RUN");
    }

    @Override
    public void close() {
        System.out.println("PluginManager: CLOSE");
    }
}
