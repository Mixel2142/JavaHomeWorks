package com.sbt.javaschool.rnd;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class MyCollectionUtilsTest {
    List<Integer> mapSource = new ArrayList<>();
    List<Integer> mapTest = new ArrayList<>();
    {
        for (int i = 0; i < 10; i++) {
            mapSource.add(i);
        }
    }

    @Test
    public void addAll() {
        MyCollectionUtils.addAll(mapSource, mapTest);
        for (Integer o : mapSource) {
            assertTrue(mapTest.contains(o));
        }
    }

    @Test
    public void indexOf() {
        for (Integer integer : mapSource) {
            assertEquals(integer, (Integer) MyCollectionUtils.indexOf(mapSource, integer));
        }
    }

    @Test
    public void add() {
        List<Integer> mapSource = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyCollectionUtils.add(mapSource,i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i, (int)MyCollectionUtils.indexOf(mapSource, i));
        }
    }

    @Test
    public void removeAll() {
        List<Integer> mapSource = new ArrayList<>();
        List<Integer> mapSource1 = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                mapSource.add(i);
            }

        for (int i = 10; i < 20; i++) {
            mapSource1.add(i);
        }

        MyCollectionUtils.removeAll(mapSource,mapSource1);

        for (int i = 10; i < 20; i++) {
            assertEquals( -1,MyCollectionUtils.indexOf(mapSource,i));
        }
    }

    @Test
    public void containsAll() {
        List<Integer> mapSource = new ArrayList<>();
        List<Integer> mapSource1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mapSource.add(i);
            mapSource1.add(i);
        }

        assertTrue(MyCollectionUtils.containsAll(mapSource,mapSource1));

        mapSource.add(100);
        assertFalse(MyCollectionUtils.containsAll(mapSource1,mapSource));
    }

    @Test
    public void containsAny() {
        List<Integer> mapSource = new ArrayList<>();
        List<Integer> mapSource1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mapSource.add(i);
        }

        assertFalse(MyCollectionUtils.containsAny(mapSource,mapSource1));

        mapSource1.add(5);

        assertTrue(MyCollectionUtils.containsAny(mapSource1,mapSource));

    }
}