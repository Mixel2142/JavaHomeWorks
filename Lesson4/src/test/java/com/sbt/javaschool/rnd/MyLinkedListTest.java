package com.sbt.javaschool.rnd;

import javafx.util.converter.IntegerStringConverter;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    MyLinkedList<String> listStr = new MyLinkedList<String>();
    List<String> str = new LinkedList<String>();
    Random rnd = new Random();

    {
        str.add("1");
        str.add("2");
        str.add("3");
        str.add("4");
        str.add("5");
    }

    @Test
    public void firstMockitoTest() {
        MyLinkedList<String> myLinckedListMock = Mockito.mock(MyLinkedList.class);

        myLinckedListMock.add("test");

        myLinckedListMock.addAll(str);
        Mockito.verify(myLinckedListMock, Mockito.times(1)).add(Mockito.any());

    }

    @Test
    public void getSize() {
        MyLinkedList<String> listStr = new MyLinkedList<String>();

        Integer iterations = rnd.nextInt(10);
        for (Integer i = 0; i < iterations; i++) {
            listStr.add(i.toString());
        }

        assertEquals((long) iterations, listStr.getSize());
    }

    @Test
    public void add() {
        listStr.add("Str");
        assertEquals("Str",listStr.get(0));
    }

    @Test
    public void remove() {

       int iterations =20;
        for (Integer i = 0; i < iterations; i++) {
            listStr.add(i.toString());
        }

        Integer tst1 = 0;
        assertEquals(tst1.toString(),listStr.remove(0));

        tst1 = 1;
        assertEquals(tst1.toString(),listStr.remove(0));

        tst1 = 19;
        assertEquals(tst1.toString(),listStr.remove(17));

        tst1 = 12;
        assertEquals(tst1.toString(),listStr.remove(10));

    }

    @Test
    public void myIterator() {
        listStr.addAll(str);
        List<String> testStr = new ArrayList<String>();

        for (String it : listStr) {
            testStr.add(it);
        }

        for (int i = 0; i < testStr.size(); i++) {
            assertEquals(testStr.get(i),listStr.get(i));
        }
    }
}