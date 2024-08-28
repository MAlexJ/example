package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.reduce;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * T reduce(T identity, BinaryOperator<T> accumulator)
 *
 * This is a terminal operation.
 *
 * Reduction stream operations allow us to produce one single result from a sequence of elements
 */
public class Reduce_method extends AbstractUtils {

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

  /**
   * 1. Without identity return type -> Optional<T> <br>
   * 2. with identity - T
   */
  @Test
  public void reduceWithIdentityAndWithoutIdentity() {
    Optional<Integer> withoutIdentity = Stream.of(1, 2, 3, 4, 5).reduce(Integer::sum);
    Integer withIdentity = Stream.of(1, 2, 3, 4, 5).reduce(0, Integer::sum);
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

  /**
   * Reduce sequential stream
   *
   * <p>link:
   * https://stackoverflow.com/questions/24308146/why-is-a-combiner-needed-for-reduce-method-that-converts-type-in-java-8
   *
   * <p>What if you don't want to parallelize your stream? Well, a combiner needs to be provided
   * anyway, but it will never be invoked, given that no partial results will be produced.
   */
  @Test
  public void identityWithAccumulatorAndCombiner() {
    Integer reduce =
        Stream.of(new User("Alex", 1), new User("Bob", 2), new User("Bob", 3))
            .reduce(
                0,
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
                  println("2.");
                  /** WTF! never use */
                  throw new RuntimeException();
                });
    println("reduce: ", reduce);
    assertThat(reduce).isEqualTo(6);
  }

  /**
   * link:
   * https://stackoverflow.com/questions/24308146/why-is-a-combiner-needed-for-reduce-method-that-converts-type-in-java-8
   */
  @Test
  public void parallelStreamWithCombiner() {
    Integer reduce =
        Stream.of(new User("Alex", 1), new User("Bob", 2), new User("Bob", 3))
            /** parallel stream */
            .parallel()
            .reduce(
                0,
                (partialAgeResult, secondUser) -> {
                  println(
                      "1. ",
                      Thread.currentThread().getName(),
                      ", partialAgeResult = ",
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

                  println(
                      "2.",
                      Thread.currentThread().getName(),
                      ", a =",
                      a,
                      ", b=",
                      b,
                      ", a + b = ",
                      a + b); // WTF! never use
                  return a + b;
                });

    println("reduce: ", reduce);
    assertThat(reduce).isEqualTo(6);
  }

  record User(String name, Integer age) {}
}
