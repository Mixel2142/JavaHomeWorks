package com.sbt.javaschool.rnd;

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
            Person buffPerson = spouse;
            spouse = null;
            buffPerson.divorce();
            return true;
        }
        return false;
    }

}


