package com.malex.lecture_2_statements;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AbstractStatements {

    protected void wrapper(String description, Runnable r) {
        println(description);
        r.run();
        println();
    }

    protected void println(String... str) {
        System.out.println(String.join(" ", str));
    }

    protected void println(Object... args) {
        String logs = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(" "));
        System.out.println(logs);
    }

    protected void print(Object... args) {
        String logs = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(" "));
        System.out.print(logs);
    }
}
