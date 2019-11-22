package com.sbt.javaschool.rnd;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

public class MyCollectionUtils {
    public static <E> void addAll(Collection<? extends E> source, Collection<? super E> destination) {
        destination.addAll(source);
    }

    public static <T> int indexOf(List<? extends T> source, T o) {

        try {
            return source.indexOf(o);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? extends T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T it : c1) {
            if (c2.contains(it))
                return true;
        }
        return false;
    }



//    public static <T> List range(List<T> list, T min, T max) {
//
//    }
//
//    public static <T> List<? extends T> range(List<? extends T> list, T min, T max, Comparator comparator) {
//    }

}
