package com.sbt.javashool.rnd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
//@return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
    @Test
    public void gomoMansMarry() {
        Person person1 = new Person(Person.GenderState.MAN, "Ivan");
        Person person2 = new Person(Person.GenderState.MAN, "Vova");

        boolean act = person1.marry(person2);

        assertFalse(act);
    }

    @Test
    public void gomoWoMansMarry() {
        Person person1 = new Person(Person.GenderState.WOMAN, "Masha");
        Person person2 = new Person(Person.GenderState.WOMAN, "Rita");

        boolean act = person1.marry(person2);

        assertFalse(act);
    }

    @Test
    //@return - returns true if this person has another gender than passed person
    public void traditionMarry() {
        Person person1 = new Person(Person.GenderState.MAN, "Ivan");
        Person person2 = new Person(Person.GenderState.WOMAN, "Rita");

        boolean act = person1.marry(person2);

        assertTrue(act);
    }

    @Test
    //@return - returns true if they are not husband and wife, false otherwise
    public void marriedMarry() {
        Person person1 = new Person(Person.GenderState.MAN, "Ivan");
        Person person2 = new Person(Person.GenderState.WOMAN, "Rita");

        person1.marry(person2);

        boolean act = person2.marry(person1);

        assertFalse(act);
    }

    @Test
    public void divorce() {

        Person person1 = new Person(Person.GenderState.MAN, "Ivan");
        boolean act1 = person1.divorce();
        assertFalse(act1); // don't change status

        Person person2 = new Person(Person.GenderState.MAN, "Ivan");
        Person person3 = new Person(Person.GenderState.WOMAN, "Rita");
        person2.marry(person3);
        boolean act2 = person2.divorce();
        assertTrue(act2); // both change status

        boolean act3 = person3.divorce();
        assertFalse(act3); // already status was changed

    }
}