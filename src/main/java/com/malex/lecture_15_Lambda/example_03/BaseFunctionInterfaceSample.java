package com.malex.lecture_15_Lambda.example_03;

import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import lombok.extern.log4j.Log4j;

/**
 * Example Stream API:
 *
 * <p>Predicate<T> Consumer<T> Function<T,R> Supplier<T> UnaryOperator<T> BinaryOperator<T>
 *
 * @author malex
 */
@Log4j
public class BaseFunctionInterfaceSample {

  public static void main(String[] args) {
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
  private static void usePredicate() {
    log.debug("Predicate <T>");

    Predicate<Integer> isPositive = x -> x > 0;

    log.debug(isPositive.test(5)); // true
    log.debug(isPositive.test(-7) + "\n"); // false
  }

  /**
   * BinaryOperator <T> takes as an argument the two objects of type T, performs a binary operation
   * on them and returns the result in an object of type T.
   */
  private static void useBinaryOperator() {
    log.debug("BinaryOperator <T> ");

    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    log.debug(multiply.apply(3, 5)); // 15
    log.debug(multiply.apply(10, -2) + "\n"); // -20
  }

  /**
   * UnaryOperator <T> takes as a parameter an object of type T, performs operations on them and
   * returns the result as an object of type T.
   */
  private static void useUnaryOperator() {
    log.debug("UnaryOperator <T>");

    UnaryOperator<Integer> square = x -> x * x;
    log.debug(square.apply(5) + "\n"); // 25
  }

  /**
   * Functional interface Function <T, R> is the transition function of an object of type T to an
   * object of type R:
   */
  private static void useFunction() {
    log.debug("Function <T,R>");

    Function<Integer, String> convert = x -> x + " долларов";

    log.debug(convert.apply(18) + "/n"); // 5 долларов
  }

  /** Consumer <T> performs an action on an object of type T, without returning anything: */
  private static void useConsumer() {
    log.debug("Consumer<T>");

    Consumer<Integer> printer = x -> log.debug(String.format("%d долларов", x));
    printer.accept(600); // 600 долларов
  }

  /** Supplier <T> takes no arguments, but must return an object of type T. */
  private static void useSupplier() {
    log.debug("Supplier<T>");

    Supplier<User> userFactory =
        () -> {
          Scanner in = new Scanner(System.in);
          log.debug("Введите имя: ");
          String name = in.nextLine();
          return new User(name);
        };

    User user1 = userFactory.get();
    User user2 = userFactory.get();

    log.debug("Name user1: " + user1.getName());
    log.debug("Name user2: " + user2.getName());
  }

  /** Class entity. */
  private static class User {
    private String name;

    User(String name) {
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
