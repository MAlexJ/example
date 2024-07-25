package com.malex.lecture_15_Lambda_Functional_Interface;

import com.malex.utils.AbstractUtils;
import java.util.UUID;
import java.util.function.*;
import org.junit.Test;

/*
 * Function interfaces:
 *
 * 1. Predicate<T>
 * 2. BiPredicate<T, U>
 * 3. Function<T,R>
 * 4. UnaryOperator<T> extends Function<T, T>
 * 5. BiFunction<T, U, R>
 * 6. BinaryOperator<T> extends BiFunction<T, T, T>
 * 7. Consumer<T>
 * 8. BiConsumer<T, U>
 * 9. Supplier<T>
 *
 */
public class BaseFunctionInterfaceSample extends AbstractUtils {

  @Test
  public void runSample() {
    /*
    * 1. Predicate<T>
    *
    * Represents a predicate (boolean-valued function) of one argument
    *
    * Type parameters:
       <T> – the type of the input to the predicate
    */
    predicate();

    /*
    * 2. BiPredicate<T, U>
    *
    * Represents a predicate (boolean-valued function) of two arguments.
    * This is the two-arity specialization of Predicate.
    *
    * Type parameters:
         <T> – the type of the first argument to the predicate
         <U> – the type of the second argument the predicate
    */
    biPredicate();

    /*
    * 3. Function<T, R>
    *
    * Represents a function that accepts one argument and produces a result.
    * This is a functional interface whose functional method is apply(Object).
    *
    * Type parameters:
          <T> – the type of the input to the function
          <R> – the type of the result of the function
    */
    function();

    /*
    *  4. UnaryOperator<T> extends java. util. function. Function<T, T>
    *
    * Represents an operation on a single operand that produces a result of the same type as its operand.
    *
    *
    * Type parameters:
       <T> – the type of the operand and result of the operator
    */
    unaryOperator();

    /*
    * 5. BiFunction<T, U, R>
    *
    * Represents a function that accepts two arguments and produces a result.
    * This is the two-arity specialization of Function.
    * This is a functional interface whose functional method is apply(Object, Object).
    *
    * Type parameters:
        <T> – the type of the first argument to the function
        <U> – the type of the second argument to the function
        <R> – the type of the result of the function
    */
    biFunction();

    /*
    * 6. BinaryOperator<T> extends BiFunction<T, T, T>
    *
    * Represents an operation upon two operands of the same type,
    * producing a result of the same type as the operands.
    * This is a specialization of BiFunction for the case where the operands and the result are all of the same type.
    * This is a functional interface whose functional method is apply(Object, Object).
    *
    *   Type parameters:
         <T> – the type of the operands and result of the operator
    */
    binaryOperator();

    /*
    * 7. Consumer<T>
    * Performs an action on an object of type T, without returning anything
    *
    * Type parameters:
        <T> – the type of the input to the operation
    */
    consumer();

    /*
    * 8. BiConsumer<T, U>
    * Represents an operation that accepts two input arguments and returns no result. This is the two-arity specialization of Consumer. Unlike most other functional interfaces, BiConsumer is expected to operate via side-effects.
    *
    * Type parameters:
        <T> – the type of the first argument to the operation
        <U> – the type of the second argument to the operation
    */
    biConsumer();

    /*
    * 9. Supplier <T> takes no arguments, must return an object of type T.
    *
    * Type parameters:
      <T> – the type of results supplied by this supplier
    */
    supplier();
  }

  /*
   *
   */
  private void biFunction() {
    BiFunction<Integer, Double, String> biFunction =
        (num1, num2) -> num1.toString() + num2.toString();
    println("biFunction: " + biFunction.apply(1, 2.0));
  }

  /*
  * Functional interface Predicate <T> verify compliance with certain conditions.
  * If it is the case, then it returns true.
  * The parameter lambda expression takes an object of type T:
  *
   public interface Predicate<T> {
       boolean test_queue(T t);
    }
  *
  */
  private void predicate() {
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

  private void biPredicate() {
    BiPredicate<Integer, Integer> isPositive = (x, y) -> x > 0 || y > 0;
    println(" 5 or 7 is positive:", isPositive.test(5, 7));
  }

  /*
   * BinaryOperator <T> takes as an argument the two objects of type T,
   * performs a binary operation on them and returns the result in an object of type T.
   */
  private void binaryOperator() {
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    println(
        "BinaryOperator <T>\n", //
        "multiply 3 and 5 =",
        multiply.apply(3, 5));
    println(
        "multiply 10 and -2 =", //
        multiply.apply(10, -2) + "\n");
  }

  /*
   * UnaryOperator <T> takes as a parameter an object of type T,
   * performs operations on them
   * and returns the result as an object of type
   */
  private void unaryOperator() {
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
  private void function() {
    Function<Integer, String> convert = x -> x + " $";
    println("Function <T,R>\n", convert.apply(5), "\n"); // 5$
  }

  /*
  * Consumer <T> performs an action on an object of type T, without returning anything
  *
  * Type parameters:
      <T> – the type of the input to the operation
  */
  private void consumer() {
    Consumer<Integer> printer = x -> println("Consumer<T>\n", String.format("%d $", x), "\n");
    printer.accept(600); // 600$
  }

  /*
  * BiConsumer<T, U>
  * Represents an operation that accepts two input arguments and returns no result. This is the two-arity specialization of Consumer. Unlike most other functional interfaces, BiConsumer is expected to operate via side-effects.
  *
  * Type parameters:
      <T> – the type of the first argument to the operation
      <U> – the type of the second argument to the operation
  */
  private void biConsumer() {
    BiConsumer<String, Integer> biConsumer =
        ((string, integer) -> {
          println("string:", string, ", number:", integer);
        });
    biConsumer.accept("hi!", 3);
  }

  /*
  * Supplier <T> takes no arguments, must return an object of type T.
  *
  * Type parameters:
    <T> – the type of results supplied by this supplier
  */
  private void supplier() {
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
