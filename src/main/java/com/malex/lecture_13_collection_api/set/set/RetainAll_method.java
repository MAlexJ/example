package com.malex.lecture_13_collection_api.set.set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/*
 *  boolean retainAll(Collection<?> c);
 *
 * Retains only the elements in this set that are contained in the specified collection (optional operation).
 *
 * In other words, removes from this set all of its elements that are not contained in the specified collection.
 *
 * If the specified collection is also a set, this operation effectively modifies this set so that its value
 * is the intersection of the two sets.
 */
public class RetainAll_method extends AbstractUtils {

  private final Set<Integer> initSet = Set.of(1, 2, 3, 4, 5);
  private final int initCollectionSize = initSet.size();

  /*
   * In other words, removes from this set all of its elements that are not contained in the specified collection.
   *
   * If the specified collection is also a set, this operation effectively modifies this set so that its value
   * is the intersection of the two sets.
   */
  @Test
  public void retainAll() {
    println("Check the return type of 'retainAll' method");

    // given
    var numbers = new HashSet<>(initSet);
    println("The initial set:", numbers);

    // and
    var set = Set.of(2, 3);
    println("The intersection set:", set);

    // when: this is the intersection of the two sets
    boolean hasCollectionChanged = numbers.retainAll(set);
    println("Has the original collection been changed:", hasCollectionChanged);
    println("After applying 'retainAll' method:", numbers);

    // then
    assertTrue(hasCollectionChanged);

    // and
    assertEquals(Set.of(2, 3), numbers);
  }

  /*
  * Result set always empty
   */
  @Test
  public void retainAll_empty_set() {
    var map = new HashMap<String, List<Set<Integer>>>();

    // case 1
    map.put("The initial set with empty set", List.of(initSet, Set.of()));

    // case 2
    map.put("The empty set with empty set", List.of(Set.of(), Set.of()));

    // case 3
    map.put("The empty set with initial set", List.of(Set.of(), initSet));

    map.forEach(
        (k, v) -> {
          println("Check the return type of 'retainAll' method for: ", k);
          Set<Integer> numbers = new HashSet<>(v.getFirst());
          println("The initial set:", numbers);

          Set<Integer> set = v.getLast();
          println("The intersection set:", set);

          boolean hasCollectionChanged = numbers.retainAll(set);
          println("Has the original collection been changed:", hasCollectionChanged);
          println("After applying 'retainAll' method:", numbers, "\n");

          // then
          if (!numbers.isEmpty()) assertTrue(hasCollectionChanged);

          // and
          assertTrue(initCollectionSize > numbers.size());

          // and: empty
          assertEquals(numbers.size(), 0);
        });
  }

  @Test
  public void returnsTypeOfRetainAll_false() {
    println(
        "Check the return type of 'retainAll' method where intersection is present and sets are equals");

    // given
    var numbers = new HashSet<>(initSet);
    println("The initial set:", numbers);

    // and
    var set = initSet;
    println("The intersection set:", set);

    // when: retain All the same numbers
    boolean hasCollectionChanged = numbers.retainAll(set);
    println("Has the original collection been changed:", hasCollectionChanged);
    println("After applying 'retainAll' method:", numbers);

    // then: Not changed by the application of the `retainAll(...)` method
    assertFalse(hasCollectionChanged);

    // and
    assertTrue(initCollectionSize == numbers.size());

    // and: not empty
    assertEquals(numbers.size(), 5);
  }

  @Test
  public void returnsTypeOfRetainAll_true_with_intersection() {
    println("Check the return type of 'retainAll' method where intersection is present");

    // given
    var numbers = new HashSet<>(initSet);
    println("The initial set:", numbers);

    // and
    var set = Set.of(1, 2, 3);
    println("The intersection set:", set);

    // when: collection changed as a result of the call
    boolean hasCollectionChanged = numbers.retainAll(set);
    println("Has the original collection been changed:", hasCollectionChanged);
    println("After applying 'retainAll' method:", numbers);

    // then
    assertTrue(hasCollectionChanged);

    // and
    assertTrue(initCollectionSize > numbers.size());

    // and: not empty
    assertEquals(3, numbers.size());
  }

  @Test
  public void returnsTypeOfRetainAll_true_no_intersection() {
    println("Check the return type of 'retainAll' method where there is no intersection");

    // given
    var numbers = new HashSet<>(initSet);
    println("the initial set:", numbers);

    // and
    var set = Set.of(8, 9, 10, 11);
    println("The intersection set:", set);

    // when: collection changed as a result of the call
    boolean hasCollectionChanged = numbers.retainAll(set);
    println("has the initial collection been changed:", hasCollectionChanged);
    println("After applying 'retainAll' method:", numbers);

    // then
    assertTrue(hasCollectionChanged);

    // and
    assertTrue(initCollectionSize > numbers.size() && numbers.size() == 0);

    // and: not empty
    assertTrue(numbers.isEmpty());
  }
}
