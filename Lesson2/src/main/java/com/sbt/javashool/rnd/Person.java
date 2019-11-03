package com.sbt.javashool.rnd;

public class Person {
    private final boolean man;
    private final String name;

    private Person spouse;
    
    public Person(boolean man, String name, Person spouse) {
        this.man = man;
        this.name = name;
        this.spouse = spouse;
    }
}
