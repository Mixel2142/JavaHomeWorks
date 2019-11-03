package com.sbt.javashool.rnd;

public class Person {

    public enum GenderState {
        MAN,
        WOMAN
    }

    private final GenderState gender;
    private final String name;

    private Person spouse;

    public Person(GenderState gender, String name) {
        this.gender = gender;
        this.name = name;
    }

    public boolean marry(Person person) {
        if (this.gender != person.gender && this.spouse != person) {
            this.divorce();
            this.spouse = person;
            person.marry(this);
            return true;
        }
        return false;
    }

    public boolean divorce() {
        if (spouse != null) {
            spouse.divorce();
            spouse = null;
            return true;
        }
        return false;
    }

}


