package com.malex.lecture_15_Lambda_Functional_Interface.unary_operator.examples;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import org.junit.Test;

// UnaryOperator<T> extends java. util. function. Function<T, T>
public class List_ReplaceAll_method extends AbstractUtils {

  private final List<Cat> cats =
      List.of(
          new Cat("Uma", 6), //
          new Cat("Stephan", 10), //
          new Cat("Cat", 5), //
          new Cat("May", 2));

  @Test
  public void replaceAll() {
    // given
    var catArrayList = new ArrayList<>(cats);

    // when
    UnaryOperator<Cat> replaceCatByCriteria =
        cat -> {
          if (cat.age < 5) {
            return new Cat("Unnamed", -1);
          }
          return cat;
        };

    // and
    catArrayList.replaceAll(replaceCatByCriteria);

    // then
    assertThat(catArrayList).doesNotContain(new Cat("May", 2));

    // and
    assertThat(catArrayList).contains(new Cat("Unnamed", -1));
  }

  private record Cat(String name, int age) {}
}
