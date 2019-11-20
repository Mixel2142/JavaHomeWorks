package com.sbt.javaschool.rnd;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    MyLinkedList<String> listStr = new MyLinkedList<String>();
    List<String> str = new LinkedList<String>();

    {
        str.add("1");
        str.add("2");
        str.add("3");
        str.add("4");
        str.add("5");
    }


    @Test
    public void getSize() {
        MyLinkedList<String> listStr = new MyLinkedList<String>();

        Random rnd = new Random();

        Integer iterations = rnd.nextInt(10);
        for (Integer i = 0; i < iterations; i++) {
            listStr.add(i.toString());
        }

        assertEquals((long) iterations, listStr.getSize());
    }

    @Test
    public void add() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void testAddAll() {
    }

    @Test
    public void get() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void myIterator() {
        listStr.addAll(str);
        for (String it : listStr) {
            System.out.println(it);
        }
    }
}