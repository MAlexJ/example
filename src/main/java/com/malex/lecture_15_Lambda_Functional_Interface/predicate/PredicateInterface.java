package com.malex.lecture_15_Lambda_Functional_Interface.predicate;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;

/**
 * Represents a predicate (boolean-valued function) of one argument.
 *
 * <p>This is a functional interface whose functional method is test(Object).
 *
 * <p>>> default boolean removeIf(Predicate<? super E> filter)
 */
public class PredicateInterface extends AbstractUtils {

  @Test
  public void collectionRemoveIf() {
    // given
    var uma = new Cat("Uma", 6);
    var stephan = new Cat("Stephan", 10);
    var cat = new Cat("Cat", 5);
    var may = new Cat("May", 2);

    // when
    var cats = new ArrayList<>(List.of(uma, stephan, cat, may));

    // default boolean removeIf(Predicate<? super E> filter)
    Predicate<Cat> predicate = c -> c.age() < 6;
    cats.removeIf(predicate);

    // method reference
    cats.removeIf(this::removeCatByAge);
    println(cats);

    // then
    assertEquals(2, cats.size());
  }

  // Cat under 6 years old
  private boolean removeCatByAge(Cat cat) {
    return cat.age() < 6;
  }

  private record Cat(String name, int age) {}
}
