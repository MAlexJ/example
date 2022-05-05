package com.malex.lecture_25_Java_8.example_19_NumStream;

import lombok.extern.java.Log;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Log
public class SampleNumStream {

    public static void main(String[] args) {

        long count = LongStream.range(1, 100).count();
        log.info("count: " + count);

        long countInt = IntStream.range(-100, 0).count();
        log.info("countInt: " + countInt);

        // using DoubleStream.generate() method
        // to generate 7 random Double values
        DoubleStream stream = DoubleStream.generate(() -> (Math.random() * 10000));

        // Displaying the randomly generated values
        stream.limit(7).forEach(el -> log.info("el: " + el));
    }
}