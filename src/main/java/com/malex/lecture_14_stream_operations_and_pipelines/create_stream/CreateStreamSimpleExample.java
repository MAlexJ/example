package com.malex.lecture_14_stream_operations_and_pipelines.create_stream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * Creating stream <br>
 * link: <a href="https://www.geeksforgeeks.org/10-ways-to-create-a-stream-in-java/">10 ways to
 * create stream</a>
 */
public class CreateStreamSimpleExample extends AbstractUtils {

    /** 1. Using Collection Approach */
    @Test
    public void collectionStream() {
        var list = List.of("Aa", "Bcd", "tyu");
        Stream<String> stream = list.stream();
        stream.forEach(this::println);
    }

    /** 2. Create a stream from specified values Stream.of(T…t) method */
    @Test
    public void streamOf() {
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        var list = stream.peek(el -> println("el->", el)).toList();
        println("list:", list);
    }

    /** 3. Create stream from an array: The Stream.of() and Arrays.stream() */
    @Test
    public void arraysStream() {
        Stream<String> stringStream = Arrays.stream(new String[] {" a1", " a2", " a3"});
        stringStream.forEach(this::println);
    }

    /** 4. Create an empty stream using Stream.empty() */
    @Test
    public void emptyStream() {
        Stream<Object> emptyStream = Stream.empty();
        assertNotNull(emptyStream);
    }

    /** 5. Create a Stream using Stream.builder() */
    @Test
    public void streamBuilder() {
        // case 1
        Stream<Object> objectStream = Stream.builder().add("As").add("Bb").add("Cz").build();

        // case 2
        Stream.Builder<String> streamBuilder = Stream.builder();

        // Add elements to the stream
        streamBuilder.add("Hello");
        streamBuilder.add("World");
        streamBuilder.add("!");

        // Build the stream
        var stringStream = streamBuilder.build();
        stringStream.forEach(this::println);
    }

    // 6. Create an infinite Stream using Stream.iterate()

    // 7. Create an infinite Stream using Stream.generate()

    // 8. Create stream from Iterator Iterators, in Java, are used in Collection Framework to retrieve
    // elements one by one.
    // Spliterator is the key to create the sequential stream.

    @Test
    public void intStream() {
        Stream<Integer> stream = IntStream.range(0, 5).map(num -> num + 1).boxed();
        List<Integer> list = stream.toList();
        assertEquals(List.of(1, 2, 3, 4, 5), list);
    }
}
