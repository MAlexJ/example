package com.malex.lecture_13_comparator.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class AbstractComparatorTestUtils {

    @Test
    public void simpleTest() {
        String testDescription = getDescription("simpleTest");
        print(testDescription);
        simpleTest(testDescription);
    }

    private String getDescription(String simpleTest) {
        Class<? extends AbstractComparatorTestUtils> aClass = this.getClass();
        return simpleTest;
    }

    public abstract void simpleTest(String testDescription);


    protected void print(Object... args) {
        String logs = Arrays.stream(args) //
                .filter(Objects::nonNull) //
                .map(Object::toString) //
                .collect(Collectors.joining(" "));
        System.out.println(logs);
    }

}
