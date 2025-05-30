package com.malex.lecture_15_Lambda_Functional_Interface.bi_consumer.custom;

import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import org.junit.Test;

/**
 * BiConsumer - It represents a function which takes in two arguments and produces a result.
 *
 * <p>However these kind of functions don’t return any value. <br>
 * link: https://www.geeksforgeeks.org/java-8-biconsumer-interface-in-java-with-examples/
 *
 * <p>BiConsumer - Represents an operation that accepts two input arguments and returns no result.
 * This is the two-arity specialization of {@code Consumer}. Unlike most other functional
 * interfaces, {@code BiConsumer} is expected to operate via side-effects.
 *
 * <p>Base methods:
 *
 * <ul>
 *   <li>void accept(T t, U u);
 *   <li>default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after)
 * </ul>
 */
public class BiConsumerInterface extends AbstractUtils {

  public void iterateCollections(Collection<String> strs, BiConsumer<Integer, String> consumer) {
    int position = 0;
    for (String s : strs) {
      if (s == null || s.isBlank()) {
        continue;
      }
      consumer.accept(position, s);
      position++;
    }
  }

  @Test
  public void test1() {
    Collection<String> list = Arrays.asList("A", "", "B", "C");
    iterateCollections(
        list,
        (position, val) -> {
          print(val);
          assertTrue(val != null && !val.isEmpty());
        });
  }

  @Test
  public void test2() {
    Collection<String> list = List.of("A", "", "B", "C");
    iterateCollections(
        list,
        (position, val) -> {
          switch (val) {
            case "A":
            case "B":
            case "C":
              {
                print(val);
                break;
              }
            default:
              throw new IllegalArgumentException("Not found item");
          }
        });
  }
}
