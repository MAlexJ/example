package com.malex.lecture_13_collection_api;

import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractTestUtil {

    private final static String DEFAULT_DESCRIPTION = "Default description";

    @Test
    public void simpleTest() {
        String testDescription = getAnnotationDescription("simpleTest");
        print(">>>", "Execute test '", testDescription, "'");
        simpleTest(testDescription);
        print();
    }

    @Test
    public void baseFunctionalityTest() {
        String testDescription = getAnnotationDescription("baseFunctionalityTest");
        print(">>>", "Execute test '", testDescription, "'");
        baseFunctionalityTest(testDescription);
        print();
    }

    @Test
    public void additionalFunctionalityTest() {
        String testDescription = getAnnotationDescription("additionalFunctionalityTest");
        print(">>>", "Execute test '", testDescription, "'");
        additionalFunctionalityTest(testDescription);
        print();
    }


    public abstract void simpleTest(String description);

    public abstract void baseFunctionalityTest(String description);

    public abstract void additionalFunctionalityTest(String description);


    @SneakyThrows
    private String getAnnotationDescription(String name) {
        Class<? extends AbstractTestUtil> aClass = this.getClass();
        Method method = Optional.of(aClass.getDeclaredMethod(name, String.class)) //
                .orElseThrow(() -> new IllegalArgumentException(String.format("method - '%s' not found!", name)));

        return Optional.ofNullable(method.getAnnotation(TestNameAnnotation.class)) //
                .map(TestNameAnnotation::value) //
                .orElse(DEFAULT_DESCRIPTION);
    }

    protected void print(Object... args) {
        String log = Arrays.stream(args) //
                .map(Object::toString) //
                .collect(Collectors.joining(" "));
        System.out.println(log);
    }
}
