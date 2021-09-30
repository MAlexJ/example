package com.malex.lecture_14_stream_api.example_03_skip_and_limit;

import lombok.extern.log4j.Log4j;

import java.util.stream.Stream;


/**
 * skip - returns a stream consisting of the remaining elements of this stream
 * after discarding the first n elements of the stream
 * <p>
 * limit - Returns a stream consisting of the elements of this stream,
 * truncated to be no longer than maxSize in length.
 */
@Log4j
public class StreamSkipAndLimitSample {

    public static void main(String[] args) {

        // Skip
        use_skip("Nokia 3110", "Samsung C100", "Alkatel e18", "HTC ONE");

        // Limit
        use_limit("1", "2", "3", "4", "5", "6");
    }

    /**
     * Skip stream method
     * Returns a stream consisting of the remaining elements of this stream
     * after discarding the first n elements of the stream.
     * If this stream contains fewer than n elements then an empty stream will be returned.
     * This is a stateful intermediate operation.
     * <p>
     * Params: n – the number of leading elements to skip
     * Returns: * the new stream
     * Throws:   IllegalArgumentException – if n is negative
     *
     * @param args the array of phone name.
     */
    private static void use_skip(String... args) {
        log.info("SKIP");
        Stream<String> stringStream = Stream.of(args);
        stringStream.skip(2).forEach(System.out::println);
    }

    /**
     * Limit stream
     *
     * @param args the array of name
     */
    private static void use_limit(String... args) {
        log.info("LIMIT");

        Stream<String> stringStream = Stream.of(args);
        stringStream.limit(3).forEach(System.out::println);
    }
}
