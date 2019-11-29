package com.sbt.javaschool.rnd;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class AlphabetUtils {

    public static String getAllDays(Field[] fields) throws IllegalAccessException {
        StringBuffer ret = new StringBuffer();
        for (Field it : fields) {
            if (isConstString(it)) {
                C obj = new C();
                ret.append(it.get(obj));
            }
        }
        return ret.toString();
    }

    public static boolean isConstString(Field field) {
        if (field.getType() != String.class) return false;
        if (!Modifier.isFinal(field.getModifiers())) return false;
        return true;
    }
}
