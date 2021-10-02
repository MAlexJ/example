package com.malex.lecture_14_stream_api.example_03_skip_and_limit;

import com.google.common.collect.Lists;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;


/**
 * skip - returns a stream consisting of the remaining elements of this stream
 * after discarding the first n elements of the stream
 * <p>
 * limit - Returns a stream consisting of the elements of this stream,
 * truncated to be no longer than maxSize in length.
 */
@Log4j
public class StreamSkipAndLimitSample {

    /**
     * Difference:
     * The skip(n) method is an intermediate operation that discards the first n elements of a stream.
     * The limit(n) method is another intermediate operation that returns a stream not longer than the requested size.
     */
    @Test
    public void skipAndLimitTest() {
        log.info("*********************************  SKIP  ************************************");

        // Skip - 1 element
        List<String> list = applySkip(1, "1", "2", "3", "4", "5", "6");
        assertEquals(Lists.newArrayList("2", "3", "4", "5", "6"), list);
        // Skip - 2 element
        list = applySkip(2, "1", "2", "3");
        assertEquals(Lists.newArrayList("3"), list);

        // Skip - 2 element
        list = applySkip(0, "1", "2", "3");
        assertEquals(Lists.newArrayList("1", "2", "3"), list);

        // skip negative number
        try {
            applySkip(-1, "1", "2", "3");
            throw new IllegalStateException("test fail");
        } catch (IllegalArgumentException ex) {
            log.info(ex.getMessage());
        }

        log.info("*********************************  LIMIT  ************************************");

        // Limit - 3 elements
        List<String> stringList = applyLimit(3, "1", "2", "3", "4", "5", "6");
        assertEquals(Lists.newArrayList("1", "2", "3"), stringList);

        // Limit - 0 elements
        stringList = applyLimit(0, "1", "2", "3", "4", "5", "6");
        assertEquals(Collections.emptyList(), stringList);

        // Limit more that size of list
        String[] arr = {"1", "2", "3", "4", "5", "6"};
        stringList = applyLimit(arr.length + 10, arr);
        assertEquals(Arrays.asList(arr), stringList);

        // Limit negative number
        try {
            applyLimit(-1, "1", "2", "3");
            throw new IllegalStateException("test fail");
        } catch (IllegalArgumentException ex) {
            log.info(ex.getMessage());
        }
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
     * Throws:  IllegalArgumentException – if n is negative
     */
    private List<String> applySkip(int skip, String... args) {
        List<String> result = Stream.of(args)
                .skip(skip)
                .collect(Collectors.toList());
        log.info(String.format("Skip %s elements in collection - %s", skip, Arrays.toString(args)));
        log.info(String.format("result - %s", result) + "\n");
        return result;
    }

    /**
     * Limit stream method
     * Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
     * This is a short-circuiting stateful intermediate operation.
     * Params: maxSize – the number of elements the stream should be limited to
     * Returns:  the new stream
     * Throws: IllegalArgumentException – if maxSize is negative
     */
    private List<String> applyLimit(int limit, String... args) {
        List<String> result = Stream.of(args)
                .limit(limit)
                .collect(Collectors.toList());
        log.info(String.format("Limit %s list to %s items", Arrays.toString(args), limit));
        log.info(String.format("result - %s", result) + "\n");
        return result;
    }
}