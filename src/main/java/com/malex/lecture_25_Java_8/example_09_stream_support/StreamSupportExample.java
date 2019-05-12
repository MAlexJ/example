package com.malex.lecture_25_Java_8.example_09_stream_support;

import lombok.extern.log4j.Log4j;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * StreamSupport - Low-level utility methods for creating and manipulating streams.
 */
@Log4j
public class StreamSupportExample {

    public static void main(String[] args) {

        // Case #1
        convertingIterableToStream();

        // Case #2: StreamSupport.intStream(...)
        splitOfInt();
    }

    /**
     * Converting Iterable to Stream
     * Note that the second param in StreamSupport.stream() determines
     * if the resulting Stream should be parallel or sequential.
     * You should set it true, for a parallel Stream.
     */
    private static void convertingIterableToStream() {
        Iterable<String> iterable
                = Arrays.asList("Testing", "Iterable", "conversion", "to", "Stream");

        StreamSupport.stream(iterable.spliterator(), false)
                .forEach(log::info);
    }


    private static void splitOfInt() {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Spliterator.OfInt splitOfInt = Arrays.spliterator(array);

        IntStream ds = StreamSupport
                .intStream(() -> splitOfInt, Spliterator.ORDERED, false);

        double sum = ds.sum();

        log.info("sum:" + sum);
    }
}
