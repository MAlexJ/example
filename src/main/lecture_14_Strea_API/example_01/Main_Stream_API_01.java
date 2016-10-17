package example_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Creating the simple stream
 *
 * @author malex
 */
public class Main_Stream_API_01 {

    public static void main(String[] args) {

        // example 1
        create_simple_stream();

        // example 2
        create_stream_arrays();

        // example
        create_stream_of();
    }

    /**
     * Create simple stream
     */
    private static void create_simple_stream() {

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Париж", "Лондон", "Мадрид"));

        // Get stream
        Stream<String> citiesStream = list.stream();

        // Set filter
        citiesStream = citiesStream.filter(s -> s.length() == 6);

        // Print result
        citiesStream.forEach(s -> System.out.println(s));
    }

    /**
     * Arrays.stream(.....);
     */
    private static void create_stream_arrays() {

        Stream<String> stringStream = Arrays.stream(new String[]{" a1", " a2", " a3"});

        // equals -> System.out.println(s)
        stringStream.forEach(System.out::println);

    }

    /**
     * Stream.of(.....)
     */
    private static void create_stream_of() {

        Stream<String> stringStream = Stream.of("s1", "s2", "s3");

        stringStream.forEach(System.out::println);
    }
}
