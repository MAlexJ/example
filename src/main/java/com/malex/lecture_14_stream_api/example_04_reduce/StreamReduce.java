package com.malex.lecture_14_stream_api.example_04_reduce;

import java.util.Optional;
import java.util.stream.Stream;

import static com.malex.lecture_14_stream_api.util.StreamAPIUtil.print;

/**
 * Information operations.
 * A simple example of using the method 'reduce' of Stream API.
 * Method 'reduce' perform the terminal operation.
 *
 * @author malex
 */
public class StreamReduce {

    public static void main(String[] args) {

        // example_01
        use_reduce_01();

        //example_02
        use_reduce_02();

        //example_03
        use_reduce_03("a", "b", "r", "t");

        //example_04
        use_reduce_04(new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000),
                new Phone("LG G 4", 32000));
    }

    /**
     * A Simple example of using the method 'reduce' of Stream API.
     * Using: BinaryOperator<T>
     * n1 op n2 op n3 op n4 op n5 op n6, where op - is the operation, а n1, n2, ... - elements from Stream.
     */
    private static void use_reduce_01() {

        print("EXAMPLE_01");

        // 1. Create the Stream
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        // 2. Apply the method 'reduce' to the stream
        Optional<Integer> reduceOptional = integerStream.reduce((x, y) -> x + y);

        // 3. Get the result of 'Optional'
        int result = reduceOptional.get();

        // 4. Print result to the console
        System.out.println("Result: " + result);

        print();
    }


    /**
     * Example of using concatenation strings in the stream.
     */
    private static void use_reduce_02() {
        print("EXAMPLE_02");

        Stream<String> stringStream = Stream.of("ab", "cd", "efg");
        Optional<String> stringOptional = stringStream.reduce((x, y) -> x + " " + y);
        String result = stringOptional.get();
        System.out.println("Result: " + result);

        print();
    }

    /**
     * identity op n1 op n2 op n3 op n4...
     *
     * @param args incoming values
     */
    private static void use_reduce_03(String... args) {
        print("Example 03");

        Stream<String> stringStream = Stream.of(args);
        String reduceSrt = stringStream.reduce("RESULT: ", (x, y) -> x + y);
        System.out.println(reduceSrt);

        print();
    }

    private static void use_reduce_04(Phone... phones) {
        print("EXAMPLE 04");

        Stream<Phone> phoneStream = Stream.of(phones);

        int sum = phoneStream.reduce(
                // :1
                0,
                // :2
                (x, y) -> {
                    if (y.getPrice() < 50000)
                        return x + y.getPrice();
                    else
                        return x;
                },
                // :3
                (x, y) -> x + y);

        System.out.println(sum);

        print();
    }

    /**
     * The class describes an entity.
     */
    private static class Phone {

        private String name;
        private int price;

        Phone(String name, int price) {
            this.name = name;
            this.price = price;
        }

        String getName() {
            return name;
        }

        int getPrice() {
            return price;
        }
    }
}
