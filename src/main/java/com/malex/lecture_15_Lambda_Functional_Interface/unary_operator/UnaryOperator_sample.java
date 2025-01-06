package com.malex.lecture_15_Lambda_Functional_Interface.unary_operator;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import org.junit.Test;

/*
 *  UnaryOperator<T> extends java. util. function. Function<T, T>
 *
 * In Java 8, UnaryOperator is a functional interface and it extends Function.
 * The UnaryOperator takes one argument, and returns a result of the same type of its arguments.
 * The Function takes one argument of any type and returns a result of any type.
 *
 * @FunctionalInterface public interface Function<T, R> {
 *    R apply(T t);
 * }
 *
 * @FunctionalInterface public interface UnaryOperator<T> extends Function<T, T>
 * Returns a unary operator that always returns its input argument.
 * static<T> UnaryOperator<T>
 * identity(){  return t->t; }
 */
public class UnaryOperator_sample extends AbstractUtils {

  @Test
  public void testIdentity() {
    UnaryOperator<Boolean> func = UnaryOperator.identity();
    print("first: " + func.apply(true));
    print("second: " + func.apply(false));
  }

  @Test
  public void test() {
    Function<Integer, Integer> func = x -> x + 1;
    print("Function: " + func.apply(1));

    UnaryOperator<Integer> uFunction = x -> x - 1;
    print("Function: " + uFunction.apply(1));
  }

  @Test
  public void applyTest() {
    List<Integer> list = List.of(1, 2, 3);
    print("Init: " + list);

    List<Integer> result = math(list, x -> x + 1);
    print("Result: " + result);
  }

  // re-name
  private <T> List<T> math(List<T> list, UnaryOperator<T> func) {
    return list.stream() //
        .map(func) //
        .toList();
  }

  @Test
  public void chainApplyTest() {
    List<Integer> list = List.of(1, 2, 3);
    print("Init: " + list);
  }

  private <T> List<T> applyChainFunc(
      List<T> list,
      UnaryOperator<T> first, //
      UnaryOperator<T> second, //
      UnaryOperator<T> third) {
    return list.stream() //
        .map(
            t ->
                first //
                    .andThen(second) //
                    .andThen(third) //
                    .apply(t)) //
        .toList();
  }
}
