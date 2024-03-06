package com.malex.lecture_15_Lambda_FunctionalInterface.functional_interface.predicate;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * In Java 8 <br>
 * >> interface Collection<E> <br>
 * >> default boolean removeIf(Predicate<? super E> filter)
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
    cats.removeIf(c -> c.age() < 6);

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
