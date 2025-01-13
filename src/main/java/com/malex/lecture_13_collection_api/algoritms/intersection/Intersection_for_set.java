package com.malex.lecture_13_collection_api.algoritms.intersection;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class Intersection_for_set extends AbstractUtils {

  /*
   * Applies a conditional check to retain only the common elements present in both sets
   *
   * Predicate: .filter(el -> verificationSet.contains(el))
   */
  public static <E> Set<E> intersection(Set<E> initialSet, Set<E> verificationSet) {
    // 1. Validate input parameters
    if (initialSet.isEmpty() || verificationSet.isEmpty()) return Collections.emptySet();

    // 2. Applies a predicate to retain only the common elements present in both sets
    return initialSet.stream()
        // predicate: .filter(el -> verificationSet.contains(el))
        .filter(verificationSet::contains)
        .collect(Collectors.toSet());
  }

  /*
   * Using of 'boolean retainAll( Collection<?> c )' method
   *
   * Retains only the elements in this set that are contained in the specified collection (optional operation).
   * In other words, removes from this set all of its elements that are not contained in the specified collection.
   *
   * If the specified collection is also a set, this operation effectively modifies this set so that its value
   * is the intersection of the two sets.
   */
  public static <E> Set<E> intersection_retainAll(Set<E> initialSet, Set<E> verificationSet) {
    // 1. Validates the input parameters for the method to ensure correctness
    if (initialSet.isEmpty() || verificationSet.isEmpty()) return Collections.emptySet();

    // 2. Create a new temporary set that doesn't modify the existing collection
    Set<E> intersection = new HashSet<>(initialSet);

    // 3. calculate the intersection of two sets
    intersection.retainAll(verificationSet);

    // 4. return the set of elements that have intersections
    return intersection;
  }

  @Test
  public void intersectionTest() {
    assertEquals(Set.of(), intersection(Set.of(4, 2), Set.of(1, 3)));
    assertEquals(Set.of(1), intersection(Set.of(1, 2), Set.of(1, 3)));
    assertEquals(Set.of(2, 4), intersection(Set.of(2, 4), Set.of(1, 2, 4)));

    // empty
    assertEquals(Set.of(), intersection_retainAll(Set.of(), Set.of(1, 3)));
    assertEquals(Set.of(), intersection_retainAll(Set.of(), Set.of()));
    assertEquals(Set.of(), intersection_retainAll(Set.of(1, 3), Set.of()));
  }

  @Test
  public void intersection_retainAll_test() {
    assertEquals(Set.of(), intersection_retainAll(Set.of(4, 2), Set.of(1, 3)));
    assertEquals(Set.of(1), intersection_retainAll(Set.of(1, 2), Set.of(1, 3)));
    assertEquals(Set.of(2, 4), intersection_retainAll(Set.of(2, 4), Set.of(1, 2, 4)));

    // empty
    assertEquals(Set.of(), intersection_retainAll(Set.of(), Set.of(1, 3)));
    assertEquals(Set.of(), intersection_retainAll(Set.of(), Set.of()));
    assertEquals(Set.of(), intersection_retainAll(Set.of(1, 3), Set.of()));
  }
}
