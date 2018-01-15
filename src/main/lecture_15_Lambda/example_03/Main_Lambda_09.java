package example_03;

import java.util.Scanner;
import java.util.function.*;

/**
 * Example Stream API:
 * <p>
 * Predicate<T>
 * Consumer<T>
 * Function<T,R>
 * Supplier<T>
 * UnaryOperator<T>
 * BinaryOperator<T>
 *
 * @author malex
 */
public class Main_Lambda_09 {

    public static void main(String[] args) {
        // Predicate<T>
        use_predicate();

        //BinaryOperator <T>
        use_binary_operator();

        //UnaryOperator<T>
        use_unary_operator();

        //Function<T,R>
        use_function();

        //Consumer<T>
        use_consumer();

        //Supplier<T>
        use_supplier();
    }

    /**
     * Functional interface Predicate <T> verify compliance with certain conditions.
     * If it is the case, then it returns true.
     * The parameter lambda expression takes an object of type T:
     * <p>
     * <pre>
     * public interface Predicate<T> {
     * boolean test_queue(T t);
     * }
     * </pre>
     */
    private static void use_predicate() {
        System.out.println("Predicate <T>");

        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7) + "\n"); // false
    }

    /**
     * BinaryOperator <T> takes as an argument the two objects of type T,
     * performs a binary operation on them and returns the result in an object of type T.
     */
    private static void use_binary_operator() {
        System.out.println("BinaryOperator <T> ");

        BinaryOperator<Integer> multiply = (x, y) -> x * y;

        System.out.println(multiply.apply(3, 5)); // 15
        System.out.println(multiply.apply(10, -2) + "\n"); // -20
    }

    /**
     * UnaryOperator <T> takes as a parameter an object of type T,
     * performs operations on them and returns the result as an object of type T.
     */
    private static void use_unary_operator() {
        System.out.println("UnaryOperator <T>");

        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5) + "\n"); // 25
    }

    /**
     * Functional interface Function <T, R> is the transition function of an object of type T to an object of type R:
     */
    private static void use_function() {
        System.out.println("Function <T,R>");

        Function<Integer, String> convert = x -> String.valueOf(x) + " долларов";
        System.out.println(convert.apply(5) + "\n"); // 5 долларов
    }

    /**
     * Consumer <T> performs an action on an object of type T, without returning anything:
     */
    private static void use_consumer() {
        System.out.println("Consumer<T>");

        Consumer<Integer> printer = x -> System.out.printf("%d долларов \n", x);
        printer.accept(600); // 600 долларов

        System.out.println();
    }

    /**
     * Supplier <T> takes no arguments, but must return an object of type T.
     */
    private static void use_supplier() {
        System.out.println("Supplier<T>");

        Supplier<User> userFactory = () -> {

            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFactory.get();
        User user2 = userFactory.get();

        System.out.println("Name user1: " + user1.getName());
        System.out.println("Name user2: " + user2.getName());
    }

    /**
     * Class entity.
     */
    private static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

}
