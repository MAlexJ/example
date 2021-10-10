package com.malex.lecture_14_stream_api.example_04_peek;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

/**
 * API Note:
 * This method exists mainly to support debugging, where you want to see the elements
 * as they flow past a certain point in a pipeline
 * <p>
 * Info: https://4comprehension.com/idiomatic-peeking/
 */
@Log4j
public class StreamPeekSample {

    @Test
    public void peekTest() {
        List<String> list = Stream.of("1", "2", "3", "4")
                .filter(this::isNumeric)
                // This method exists mainly to support debugging,
                // Stream<T> peek(Consumer<? super T> action)
                .peek(log::debug)
                .collect(Collectors.toList());

        // https://4comprehension.com/idiomatic-peeking/
        // https://blog.jooq.org/java-8-friday-10-subtle-mistakes-when-using-the-streams-api/

        assertEquals(Arrays.asList("1", "2", "3", "4"), list);

        // test: 1
        Stream.of("one", "two", "three")
                .peek(e -> log.info(e + " was consumed by peek()."))
                .forEach(log::info);

        // test2 -> empty!
        // Intermediate operations return a new stream.
        // They are always lazy;
        // executing an intermediate operation such as filter() does not actually perform any filtering,
        // but instead creates a new stream that, when traversed,
        // contains the elements of the initial stream that match the given predicate.
        // Traversal of the pipeline source does not begin until the terminal operation of the pipeline is executed.
        Stream.of("one", "two", "three")
                .peek(e -> log.info(e + " was consumed by peek()."));
    }


    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(strNum).matches();
    }
}
