package example_09_stream_support;

import java.util.Arrays;
import java.util.stream.StreamSupport;

/**
 *
 */
public class MainStreamSupport {

    public static void main(String[] args) {

        // Case #1
        convertingIterableToStream();

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
        StreamSupport.stream(iterable.spliterator(), false).forEach(System.out::println);
    }


}
