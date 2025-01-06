package com.malex.lecture_13_collection_api.algoritms.difference;

import static junit.framework.TestCase.assertEquals;

import com.malex.lecture_13_collection_api.algoritms.intersection.SetIntersection;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class SetDifference {

  public static <E> Set<E> difference(Set<E> set1, Set<E> set2) {
    // union all sets
    HashSet<E> union = new HashSet<>(set1);
    union.addAll(set2);

    // find and remove intersection
    Set<E> intersection = SetIntersection.intersection(set1, set2);
    union.removeAll(intersection);
    return union;
  }

  @Test
  public void test() {
    assertEquals(Set.of(), difference(Set.of(), Set.of()));
    assertEquals(Set.of(), difference(Set.of(1), Set.of(1)));
    assertEquals(Set.of(), difference(Set.of(1, 2, 3, 4), Set.of(1, 2, 3, 4)));

    assertEquals(Set.of(1, 2, 3, 4), difference(Set.of(1, 2), Set.of(3, 4)));
    assertEquals(Set.of(1, 2, 4, 5), difference(Set.of(1, 2, 3), Set.of(3, 4, 5)));
  }
}
