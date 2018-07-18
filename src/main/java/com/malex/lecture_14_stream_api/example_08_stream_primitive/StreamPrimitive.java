package com.malex.lecture_14_stream_api.example_08_stream_primitive;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrimitive {

    public static void main(String[] args) {

        // In addition to the regular objects of the Java 8 streams, special types of streams
        // to work with primitive data types int, long and double.
        // IntStream , LongStream and DoubleStream .
        IntStream.range(5, 8).forEach(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        IntStream.of(1, 1, 2, 3).forEach(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        // primitive flows support additional terminal operations sum() и average():
        Arrays.stream(new int[]{1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        // Sometimes it is useful to convert a stream of objects into a primitive stream or vice versa
        // For this purpose, object stream support special operations mapToInt(), mapToLong() и mapToDouble() :
        Stream.of("c1", "c2", "c3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        // Primitive streams can be converted to object flows using the method mapToObj()
        IntStream.range(1, 4)
                .mapToObj(i -> "c" + i)
                .forEach(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        // Here's a combined example: a thread with a double is first converted to an int stream and then to an object stream of strings:
        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "c" + i)
                .forEach(System.out::println);
    }
}
