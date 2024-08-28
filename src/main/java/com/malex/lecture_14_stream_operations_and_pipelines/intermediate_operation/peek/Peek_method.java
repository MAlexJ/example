package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.peek;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * peek(..) is an intermediate operation.
 *
 * Key Takeaways
 * 1. The peek() method works fine as a debugging tool when we want to see what is being consumed by a Stream
 * 2. It seems to work fine when applying mutating operations but should not be used this way because this behaviour is
 *    non-deterministic due to the possibility of certain peek() calls being omitted due to internal optimization
 * 3. The discussion, whether mutation operations should be allowed or not,
 *    would never take place if we were restricted to operate only on immutable values
 * 4. We have around 292276977 years till we run out of the java.util.Date range
 *
 * So, peek(...) We can see that non-debugging usages are neither forbidden nor discouraged.
 *
 * Idiomatic Peeking with Java Stream API:
 * link: https://4comprehension.com/idiomatic-peeking/
 * Java 8 Friday: 10 Subtle Mistakes When Using the Streams API:
 * link:  https://blog.jooq.org/java-8-friday-10-subtle-mistakes-when-using-the-streams-api/
 *
 * API Note: This method exists mainly to support debugging, where you want to see the elements as
 * they flow past a certain point in a pipeline
 *
 * <p>Info: https://4comprehension.com/idiomatic-peeking/
 */
public class Peek_method extends AbstractUtils {

  private final Predicate<String> isNumericPredicate =
      str -> str != null && Pattern.compile("-?\\d+(\\.\\d+)?").matcher(str).matches();

  /*
   * Stream<T> peek(Consumer<? super T> action);
   *
   * Returns a stream consisting of the elements of this stream,
   * additionally performing the provided action on each element as elements
   * are consumed from the resulting stream.
   */
  @Test
  public void peek() {
    var list =
        Stream.of("1", "2", "3", "4")
            .filter(isNumericPredicate)
            // This method exists mainly to support debugging,
            // Stream<T> peek(Consumer<? super T> action)
            .peek(this::println)
            .collect(Collectors.toList());

    assertEquals(Arrays.asList("1", "2", "3", "4"), list);
  }

  @Test
  public void streamPeekLazyEvaluation() {

    /*
     * but… what will happen if we replace the terminal collect() operation with a forEach()?
     *
     * It might be tempting to think that we’ll see a series of peek() logs followed by a series
     * of for-each logs but this is not the case:
     *
     * one was consumed by peek().
     * one
     * two was consumed by peek().
     * two
     * three was consumed by peek().
     * three
     */
    Stream.of("one", "two", "three")
        .peek(e -> println(e + " was consumed by peek()."))
        .forEach(this::println);
  }

  /*
   * As JavaDoc states:
   * Intermediate operations return a new stream.
   * They are always lazy; executing an intermediate operation such as filter() does not actually perform any filtering,
   * but instead creates a new stream that, when traversed,
   * contains the elements of the initial stream that match the given predicate.
   * Traversal of the pipeline source does not begin until the terminal operation of the pipeline is executed.
   */
  @Test
  public void peekIsIntermediateOperation() {
    Stream.of("one", "two", "three").peek(e -> println(e + " was consumed by peek()."));
  }

  /*
   * Stream operations and pipelines
   * link: https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html#StreamOps
   *
   * Intermediate operations return a new stream.
   * They are always lazy; executing an intermediate operation such as filter() does not actually perform any filtering,
   * but instead creates a new stream that, when traversed, contains the elements of the initial stream that match
   * the given predicate.
   * Traversal of the pipeline source does not begin until the terminal operation of the pipeline is executed.
   */
  @Test
  public void manipulateInfiniteSequences() {
    /*
     * So, we can see that peek() can’t be treated as an intermediate for-each replacement
     * because it invokes the passed Consumer only on elements that are visited by the Stream.
     */
    Optional<Integer> first =
        Stream.iterate(0, i -> i + 1).peek(num -> println("num:", num)).findFirst();

    assertTrue(first.isPresent());
    assertEquals(first.get().intValue(), 0);
  }

  /*
   * This gets clarified in the early draft of JDK 9’s docs eventually:
   *
   * In cases where the stream implementation is able to optimize away the production of some
   * or all the elements (such as with short-circuiting operations like findFirst,
   * or in the example described in count()), the action will not be invoked for those elements. (…)
   *
   * An implementation may choose to not execute the stream pipeline (either sequentially or in parallel)
   * if it is capable of computing the count directly from the stream source.
   */
  @Test
  public void optimizePeekCallsByJava() {
    long count = List.of(1, 2, 3).stream().peek(this::println).count();

    println("count:", count);
  }
}
