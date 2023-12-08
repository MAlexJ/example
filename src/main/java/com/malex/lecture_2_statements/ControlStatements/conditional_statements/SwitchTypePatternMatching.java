package com.malex.lecture_2_statements.ControlStatements.conditional_statements;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SwitchTypePatternMatching {

    /**
     * Java 21
     * Type patters with switch
     */
    @Test
    public void runNewImpl() {
        typePatternMatching(Integer.valueOf(1));
        typePatternMatching(Long.valueOf(1));
        typePatternMatching("Hello Alex!");
    }

    /**
     * Java 16 +
     * Type patters with instanceof are Java's first step towards pattern matching.
     */
    @Test
    public void runOldImpl() {
        typePatternMatchingWithInstanceof(123);
        typePatternMatchingWithInstanceof(123L);
        typePatternMatchingWithInstanceof("Hello max!");
    }

    public void typePatternMatching(Object obj) {
        switch (obj) {
            case String s -> print(s);
            case Integer i -> {
                i = i + 1;
                print("i = i + 1, result =", i);
            }
            case Long l -> {
                l = l - 1;
                print("l = l - 1, result =", l);
            }
            default -> throw new UnsupportedOperationException("Unsupported:" + obj);
        }
    }

    private void typePatternMatchingWithInstanceof(Object obj) {
        if (obj instanceof String str) {
            print("String, value:", str, ", length:", str.length());
        } else if (obj instanceof Long aLong) {
            long l = aLong + 1;
            print("Long num = ", aLong, ", number + 1 =", l);
        } else if (obj instanceof Number number) {
            print("Number - ", number, ", num to double =", number.doubleValue());
        }
    }

    private void print(Object... args) {
        String logs = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(" "));
        System.out.println(logs);
    }
}