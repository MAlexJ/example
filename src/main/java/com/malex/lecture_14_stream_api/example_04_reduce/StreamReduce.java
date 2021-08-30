package com.malex.lecture_14_stream_api.example_04_reduce;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.util.Optional;
import java.util.stream.Stream;

import static com.malex.lecture_14_stream_api.util.StreamAPIUtil.print;

/**
 * Information operations.
 * A simple example of using the method 'reduce' of Stream API.
 * Method 'reduce' perform the terminal operation.
 */
@Log4j
public class StreamReduce {

    public static void main(String[] args) {
        // BinaryOperator
        exampleOfBinaryOperator();

        // BinaryOperator
        exampleOfBinaryOperatorSecond();

        // Identity with BinaryOperator
        exampleOfIdentityWithBinaryOperator("a", "b", "r", "t");

        // Identity with BiFunction and BinaryOperator
        exapmleIdentityWithBiFunctionAndBinaryOperator(new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000),
                new Phone("LG G 4", 32000));
    }

    /**
     * A Simple example of using the method 'reduce' of Stream API.
     * Using: BinaryOperator<T>
     * n1 op n2 op n3 op n4 op n5 op n6, where op - is the operation, а n1, n2, ... - elements from Stream.
     */
    private static void exampleOfBinaryOperator() {
        print("EXAMPLE_01");

        // 1. Create the Stream
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        // 2. Apply the method 'reduce' to the stream
        Optional<Integer> reduceOptional = integerStream.reduce(Integer::sum);

        // 3. Get and print result
        reduceOptional.ifPresent(val -> log.info(String.format("Result: - %s", val)));

        print();
    }


    /**
     * Example of using concatenation strings in the stream.
     */
    private static void exampleOfBinaryOperatorSecond() {
        print("EXAMPLE_02");

        Stream<String> stringStream = Stream.of("ab", "cd", "efg");
        Optional<String> stringOptional = stringStream.reduce((x, y) -> x + " " + y);
        stringOptional.ifPresent(val -> log.info(String.format("Result: - %s", val)));

        print();
    }

    /**
     * identity op n1 op n2 op n3 op n4...
     *
     * @param args incoming values
     */
    private static void exampleOfIdentityWithBinaryOperator(String... args) {
        print("Example 03");

        Stream<String> stringStream = Stream.of(args);
        String reduceSrt = stringStream.reduce("RESULT: ", (x, y) -> x + y);
        log.info(reduceSrt);

        print();
    }

    private static void exapmleIdentityWithBiFunctionAndBinaryOperator(Phone... phones) {
        print("EXAMPLE 04");

        Stream<Phone> phoneStream = Stream.of(phones);

        int sum = phoneStream.reduce(
                // :1 init state
                0,
                // :2 additional filters
                (x, y) -> {
                    if (y.getPrice() < 50000)
                        return x + y.getPrice();
                    else
                        return x;
                },
                // :3 operation
                (x, y) -> x + y);

        System.out.println(sum);

        print();
    }

    /**
     * The class describes an entity.
     */
    @Getter
    private static class Phone {

        private String name;
        private int price;

        Phone(String name, int price) {
            this.name = name;
            this.price = price;
        }

//        String getName() {
//            return name;
//        }
//
//        int getPrice() {
//            return price;
//        }
    }
}
