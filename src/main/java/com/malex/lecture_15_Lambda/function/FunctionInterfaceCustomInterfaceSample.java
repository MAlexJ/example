package com.malex.lecture_15_Lambda.function;

import lombok.extern.java.Log;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

@Log
public class FunctionInterfaceCustomInterfaceSample {


    @Test
    public void test() {
        MyInterface<String, Integer> fn = String::length;
        assertEquals(5, (int) fn.apply("Hello"));

        MyInterface<String, Integer> first = str -> Integer.parseInt(str.replace(" ", ""));
        MyInterface<Integer, Long> second = num -> Integer.toUnsignedLong(num + 1);
        long result = first.andThen(second).apply("1 2 3");
        assertEquals(124, result);

        MyInterface<Integer, String> third = Object::toString;
        result = first.compose(third).apply(123);
        assertEquals(123, result);
    }


    @FunctionalInterface
    interface MyInterface<T, R> {

        R apply(T t);

        default <V> MyInterface<T, V> andThen(MyInterface<? super R, ? extends V> after) {
            return (T t) -> after.apply(apply(t));
        }


        default <V> MyInterface<V, R> compose(MyInterface<? super V, ? extends T> before) {
            return (V v) -> apply(before.apply(v));
        }

    }
}
