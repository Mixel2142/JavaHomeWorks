package com.sbt.javaschool.rnd.server;

public class Account {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    private String name;
    private Integer password;
    private Integer money;

    public Account(String name, Integer password, Integer money) {
        this.name = name;
        this.password = password;
        this.money = money;
    }
}
