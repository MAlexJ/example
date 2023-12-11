package com.malex.lecture_3_object;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class AbstractUtil {

    protected void print(Object... objects) {
        String logs = Arrays.stream(objects).map(Object::toString).collect(Collectors.joining(" "));
        System.out.println(logs);
    }

    protected String getHashcode(Number i) {
        return Integer.toHexString(System.identityHashCode(i));
    }

}
