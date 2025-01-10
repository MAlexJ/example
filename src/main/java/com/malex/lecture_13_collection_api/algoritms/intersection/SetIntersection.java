package com.malex.lecture_13_collection_api.algoritms.intersection;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class SetIntersection extends AbstractUtils {

  /*
   * Predicate: .filter(el -> verificationSet.contains(el))
   */
  public static <E> Set<E> intersection(Set<E> initialSet, Set<E> verificationSet) {
    return initialSet.stream()
        // predicate: .filter(el -> verificationSet.contains(el))
        .filter(verificationSet::contains)
        .collect(Collectors.toSet());
  }

  /*
   * boolean retainAll( Collection<?> c )
   *
   * Retains only the elements in this set that are contained in the specified collection (optional operation).
   * In other words, removes from this set all of its elements that are not contained in the specified collection.
   *
   * If the specified collection is also a set, this operation effectively modifies this set so that its value
   * is the intersection of the two sets.
   */
  public static <E> Set<E> intersection_retainAll(Set<E> initialSet, Set<E> verificationSet) {
    Set<E> intersection = new HashSet<>(initialSet);
    // that its value is the intersection of the two sets.
    intersection.retainAll(verificationSet);
    return intersection;
  }

  /*
   * Overload: Additional functionality
   */
  public static <E> List<E> intersection(List<E> initial, List<E> verification) {
    Set<E> intersection = intersection(new HashSet<E>(initial), new HashSet<E>(verification));
    return new ArrayList<>(intersection);
  }

  @Test
  public void intersectionTest() {
    assertEquals(Set.of(), intersection(Set.of(4, 2), Set.of(1, 3)));
    assertEquals(Set.of(1), intersection(Set.of(1, 2), Set.of(1, 3)));
    assertEquals(Set.of(2, 4), intersection(Set.of(2, 4), Set.of(1, 2, 4)));
  }

  @Test
  public void intersection_retainAll_test() {
    assertEquals(Set.of(), intersection_retainAll(Set.of(4, 2), Set.of(1, 3)));
    assertEquals(Set.of(1), intersection_retainAll(Set.of(1, 2), Set.of(1, 3)));
    assertEquals(Set.of(2, 4), intersection_retainAll(Set.of(2, 4), Set.of(1, 2, 4)));
  }
}
