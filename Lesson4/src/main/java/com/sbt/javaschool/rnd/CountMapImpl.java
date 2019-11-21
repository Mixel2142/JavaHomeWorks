package com.sbt.javaschool.rnd;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {

    private Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T o) {
        map.put(o, map.containsKey(o) ? map.get(o) + 1 : 1);
    }

    @Override
    public int getCount(T o) {


        try {
            return map.get(o);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return 0;
        }


    }

    @Override
    public int remove(T o) {
        try {
            int count = map.get(o);
            map.remove(o);
            return count;
        } finally {
            return 0;
        }
    }

    @Override
    public int size() {
        return map.size();
    }


    @Override
    public void addAll(CountMap<T> source) {
        source.toMap().forEach((key, value) -> {
            map.put(key, map.containsKey(key) ? map.get(key) + value : 1);
        });
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(map);
    }
}
