package com.malex.lecture_15_Lambda_Functional_Interface.bi_predicate;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import org.junit.Test;

/*
* BiPredicate<T, U>
*
* Represents a predicate (boolean-valued function) of two arguments.
* This is the two-arity specialization of Predicate.
* This is a functional interface whose functional method is test(Object, Object).
*
* Type parameters:
    <T> – the type of the first argument to the predicate
    <U> – the type of the second argument the predicate
 */
public class BiPredicate_sample extends AbstractUtils {

  @Test
  public void test() {
    // test 1
    BiPredicate<String, Integer> biPredicate =
        (string, number) -> {
          boolean result = (string.length() == number);
          println("string.length() == number.intValue() :", result);
          return result;
        };
    assertThat(biPredicate.test("hello", 5)).isTrue();

    // test 2
    BiPredicate<String, List<String>> lisyBiPredicate =
        (str, list) -> {
          if (list == null || list.isEmpty()) {
            return false;
          }
          return list.contains(str);
        };
    assertThat(lisyBiPredicate.test("hello", List.of("hello", "world"))).isTrue();
    assertThat(lisyBiPredicate.test("hello", List.of("world"))).isFalse();
    assertThat(lisyBiPredicate.test("hello", null)).isFalse();
    assertThat(lisyBiPredicate.test("hello", Collections.emptyList())).isFalse();
  }
}
