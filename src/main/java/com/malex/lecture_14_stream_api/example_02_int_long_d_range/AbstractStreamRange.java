package com.malex.lecture_14_stream_api.example_02_int_long_d_range;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class AbstractStreamRange {

    public AbstractStreamRange() {
        println("1. AbstractStreamRange constructor");
    }

    protected void wrapper(String description, Runnable r) {
        println(description);
        r.run();
        println("\n");
    }

    protected void print(Object... args) {
        String logs = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(" "));
        System.out.print(logs);
    }

    protected void println(Object... args) {
        String logs = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(" "));
        System.out.println(logs);
    }


}
