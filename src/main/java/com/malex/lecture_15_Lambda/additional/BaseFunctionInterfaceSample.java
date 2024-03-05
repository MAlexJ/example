package com.malex.lecture_15_Lambda.additional;

import com.malex.utils.AbstractUtils;
import java.util.UUID;
import java.util.function.*;
import org.junit.Test;

/**
 * Example Stream API: <br>
 * <br>
 * Predicate<T> <br>
 * Consumer<T> <br>
 * Function<T,R> <br>
 * Supplier<T> <br>
 * UnaryOperator<T> <br>
 * BinaryOperator<T> <br>
 */
public class BaseFunctionInterfaceSample extends AbstractUtils {

  @Test
  public void runSample() {
    // Predicate<T>
    usePredicate();

    // BinaryOperator <T>
    useBinaryOperator();

    // UnaryOperator<T>
    useUnaryOperator();

    // Function<T,R>
    useFunction();

    // Consumer<T>
    useConsumer();

    // Supplier<T>
    useSupplier();
  }

  /**
   * Functional interface Predicate <T> verify compliance with certain conditions. If it is the
   * case, then it returns true. The parameter lambda expression takes an object of type T:
   *
   * <p>
   *
   * <pre>
   * public interface Predicate<T> {
   * boolean test_queue(T t);
   * }
   * </pre>
   */
  private void usePredicate() {
    Predicate<Integer> isPositive = x -> x > 0;
    println(
        "Predicate <T>\n", //
        "Question: 5 is Positive:",
        isPositive.test(5)); // true
    println(
        "Question:", //
        "Question: -7 is Positive:",
        isPositive.test(-7) + "\n"); // false
  }

  /**
   * BinaryOperator <T> takes as an argument the two objects of type T, performs a binary operation
   * on them and returns the result in an object of type T.
   */
  private void useBinaryOperator() {
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    println(
        "BinaryOperator <T>\n", //
        "multiply 3 and 5 =",
        multiply.apply(3, 5));
    println(
        "multiply 10 and -2 =", //
        multiply.apply(10, -2) + "\n");
  }

  /**
   * UnaryOperator <T> takes as a parameter an object of type T, performs operations on them and
   * returns the result as an object of type T.
   */
  private void useUnaryOperator() {
    UnaryOperator<Integer> square = x -> x * x;
    println(
        "UnaryOperator <T> \n", //
        "Calculate the area of square:",
        square.apply(5) + "\n");
  }

  /**
   * Functional interface Function <T, R> is the transition function of an object of type T to an
   * object of type R:
   */
  private void useFunction() {
    Function<Integer, String> convert = x -> x + " $";
    println("Function <T,R>\n", convert.apply(5), "\n"); // 5$
  }

  /** Consumer <T> performs an action on an object of type T, without returning anything: */
  private void useConsumer() {
    Consumer<Integer> printer = x -> println("Consumer<T>\n", String.format("%d $", x), "\n");
    printer.accept(600); // 600$
  }

  /** Supplier <T> takes no arguments, but must return an object of type T. */
  private void useSupplier() {
    Supplier<User> userFactory =
        () -> {
          String uuid = UUID.randomUUID().toString();
          return new User(uuid);
        };

    // lazy initialization
    User user1 = userFactory.get();
    User user2 = userFactory.get();
    println("Supplier<T>\n", "First user: " + user1.name(), "Second user: " + user2.name());
  }

  /** Class entity. */
  private record User(String name) {}
}
