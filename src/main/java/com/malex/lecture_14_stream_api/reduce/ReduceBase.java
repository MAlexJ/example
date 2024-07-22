package com.malex.lecture_14_stream_api.reduce;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import org.junit.Test;

/** Reduction stream operations allow us to produce one single result from a sequence of elements */
public class ReduceBase extends AbstractUtils {

  /*
   * The Key Concepts: Identity, Accumulator and Combiner
   *
   * 1. Identity – an element that is the initial value of the reduction operation and the default
   * result if the stream is empty
   *
   * 2. Accumulator – a function that takes two parameters: a partial result of the reduction
   * operation and the next element of the stream
   *
   * 3. Combiner – a function used to combine the partial result of the reduction operation when the
   * reduction is parallelized or when there’s a mismatch between the types of the accumulator
   * arguments and the types of the accumulator implementation
   */
  @Test
  public void accumulator() {
    /*
     * Optional<T> reduce(BinaryOperator<T> accumulator);
     *
     * Accumulator – a function that takes two parameters: a partial result of the reduction
     * operation and the next element of the stream
     */
    BinaryOperator<Integer> accumulator =
        (a, b) -> {
          // 'a' is first value and then is partial result
          println("a = ", a, ",b = ", b, ", a + b =", a + b);
          return a + b;
        };

    /* stream:
     * 1,  2,     3,     4,       5
     * reduction:
     * 1 + 2 = 3
     *        3 + 3 = 6
     *                6 + 4 = 10
     *                        10 + 5 = 15
     */
    Optional<Integer> reduce = Stream.of(1, 2, 3, 4, 5).reduce(accumulator);
    println("reduce: " + reduce);
  }

  @Test
  public void identityWithAccumulator() {
    Integer identity = -15;
    BinaryOperator<Integer> accumulator =
        (a, b) -> {
          println("a = ", a, ",b = ", b, ", a + b =", a + b);
          return a + b;
        };

    Integer reduce = Stream.of(1, 2, 3, 4, 5).reduce(identity, accumulator);
    println("reduce: " + reduce);

    // assertJ test
    assertThat(reduce).isEqualTo(0);
  }

  @Test
  public void identityWithAccumulatorAndCombiner() {
    Integer reduce =
        Stream.of(new User("Alex", 1), new User("Bob", 2))
            .reduce(
                -1,
                (partialAgeResult, secondUser) -> {
                  println(
                      "1. partialAgeResult = ",
                      partialAgeResult,
                      ", secondUser.age() = ",
                      secondUser.age());
                  return partialAgeResult + secondUser.age();
                },
                (a, b) -> {
                  /*
                  if we use sequential streams and the types of the accumulator arguments
                  and the types of its implementation match, we don’t need to use a combiner.
                  */
                  println("2."); // WTF! never use
                  return a / b;
                });

    println("reduce: ", reduce);
  }

  record User(String name, Integer age) {}
}
