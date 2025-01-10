package com.malex.lecture_13_collection_api.set.set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Collections;
import java.util.HashSet;
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

  @Test
  public void retainAll_empty_set() {
    // given
    var numbers = new HashSet<>(initSet);
    println("The initial set:", numbers);

    // and
    var emptySet = Collections.emptySet();
    println("The intersection set:", emptySet);

    // when
    boolean hasCollectionChanged = numbers.retainAll(emptySet);
    println("Has the original collection been changed:", hasCollectionChanged);
    println("After applying 'retainAll' method:", numbers);

    // then
    assertTrue(hasCollectionChanged);

    // and
    assertTrue(initCollectionSize > numbers.size());

    // and: empty
    assertEquals(numbers.size(), 0);
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
    assertTrue(initCollectionSize > numbers.size());

    // and: not empty
    assertTrue(numbers.isEmpty());
    // the same: assertEquals(0, numbers.size());
  }
}
