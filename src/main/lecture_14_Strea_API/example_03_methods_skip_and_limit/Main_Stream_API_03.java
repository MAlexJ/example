package example_03_methods_skip_and_limit;

import java.util.stream.Stream;

import static util.StreamAPIUtil.print;

/**
 * @author malex
 */
public class Main_Stream_API_03 {

    public static void main(String[] args) {

        // Skip
        use_skip("Nokia 3110", "Samsung C100", "Alkatel e18", "HTC ONE");

        // Limit
        use_limit("1", "2", "3", "4", "5", "6");
    }


    /**
     * Skip stream
     *
     * @param args the array of phone name.
     */
    private static void use_skip(String... args) {
        print("SKIP");

        Stream<String> stringStream = Stream.of(args);
        stringStream.skip(2).forEach(System.out::println);

        print();
    }

    /**
     * Limit stream
     *
     * @param args the array of name
     */
    private static void use_limit(String... args) {
        print("LIMIT");

        Stream<String> stringStream = Stream.of(args);
        stringStream.limit(3).forEach(System.out::println);

        print();
    }

}
