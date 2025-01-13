package com.malex.lecture_13_collection_api.algoritms.difference;

import static junit.framework.TestCase.assertEquals;

import com.malex.lecture_13_collection_api.algoritms.intersection.Intersection_for_set;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class SetDifference {

  /*
   * Difference two sets: (set1 - set2): Elements in set1 but not in set2
   */
  public static <E> Set<E> difference(Set<E> set1, Set<E> set2) {
    // 1. prepare temp set
    var diff = new HashSet<>(set1);

    // 2. remove set2 from set1
    diff.removeAll(set2);
    return diff;
  }

  /*
   * Symmetric difference: Elements in either set1 or set2, but not both
   */
  public static <E> Set<E> symmetricDifference(Set<E> set1, Set<E> set2) {
    // 1. union all sets
    HashSet<E> union = new HashSet<>(set1);
    union.addAll(set2);

    // 2. find intersection of sets
    Set<E> intersection = Intersection_for_set.intersection(set1, set2);

    // 3. remove intersection sets
    union.removeAll(intersection);

    return union;
  }

  /*
   * Full difference  - all unique elements in both sets combined
   */
  public <E> Set<E> fullDifference(Set<E> set1, Set<E> set2) {
    Set<E> union = new HashSet<>(set1);
    union.addAll(set2);
    return union;
  }

  @Test
  public void differenceTest() {
    assertEquals(Set.of(), difference(Set.of(), Set.of()));
    assertEquals(Set.of(1), difference(Set.of(1), Set.of()));

    assertEquals(Set.of(1, 2, 3), difference(Set.of(1, 2, 3), Set.of()));
    assertEquals(Set.of(1, 2, 3), difference(Set.of(1, 2, 3), Set.of(4, 5, 6)));

    assertEquals(Set.of(1), difference(Set.of(1, 2, 3), Set.of(2, 3)));
    assertEquals(Set.of(1, 2, 3), difference(Set.of(1, 2, 3, 4, 5), Set.of(4, 5)));
  }

  @Test
  public void symmetricDifferenceTest() {
    assertEquals(Set.of(), symmetricDifference(Set.of(), Set.of()));
    assertEquals(Set.of(), symmetricDifference(Set.of(1), Set.of(1)));
    assertEquals(Set.of(), symmetricDifference(Set.of(1, 2, 3, 4), Set.of(1, 2, 3, 4)));

    assertEquals(Set.of(1, 2, 3, 4), symmetricDifference(Set.of(1, 2), Set.of(3, 4)));
    assertEquals(Set.of(1, 2, 4, 5), symmetricDifference(Set.of(1, 2, 3), Set.of(3, 4, 5)));

    assertEquals(Set.of(1, 2, 3, 4, 5), symmetricDifference(Set.of(1, 2, 3), Set.of(4, 5)));
  }

  @Test
  public void fullDifferenceTest() {
    assertEquals(Set.of(), fullDifference(Set.of(), Set.of()));
    assertEquals(Set.of(1), fullDifference(Set.of(1), Set.of(1)));
    assertEquals(Set.of(1, 2), fullDifference(Set.of(1), Set.of(1, 2)));
    assertEquals(Set.of(1, 2, 3, 4), fullDifference(Set.of(1, 2, 3, 4), Set.of(1, 2, 3, 4)));
  }
}
