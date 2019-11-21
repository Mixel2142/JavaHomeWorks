package com.sbt.javaschool.rnd;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CountMapImplTest {

    Random rnd = new Random();

    @Test
    public void addANDgetCount() {

        CountMap<Integer> map = new CountMapImpl<Integer>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        int count = map.getCount(5); // 2
        assertEquals(2, count);
        count = map.getCount((Integer) 6); // 1
        assertEquals(1, count);
        count = map.getCount((Integer) 10); // 3*/
        assertEquals(3, count);

    }

    @Test
    public void remove() {
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        map.remove(10);
        int count = map.getCount(10); // 0
        assertEquals(0, count);
    }

    @Test
    public void size() {
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        assertEquals(3, map.size());

        CountMap<Integer> zeroMap = new CountMapImpl<>();
        assertEquals(0, zeroMap.size());

        zeroMap.addAll(map);
        assertEquals(map.size(), zeroMap.size());
    }

    @Test
    public void addAll() {

        CountMap<Object> mapSource = new CountMapImpl<>();
        CountMap<Object> mapTest = new CountMapImpl<>();

        Object[] arrObj = new Object[10];

        for (int i = 0; i < arrObj.length; i++) {
            arrObj[i] = i;
            mapSource.add(i);
        }

        mapTest.addAll(mapSource);

        for (int i = 0; i < arrObj.length; i++) {
            assertEquals(1, mapTest.getCount(i));
        }

        mapTest.addAll(mapSource);

        for (int i = 0; i < arrObj.length; i++) {
            assertEquals(2, mapTest.getCount(i));
        }
    }


    @Test
    public void toMap() {
    }

}