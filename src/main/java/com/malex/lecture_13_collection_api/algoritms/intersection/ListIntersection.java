package com.malex.lecture_13_collection_api.algoritms.intersection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.algoritms.contains.ListContains;
import java.util.List;
import java.util.Objects;
import org.junit.Test;

public class ListIntersection {

  public static <E> boolean hasIntersection(List<E> first, List<E> second) {
    return first.stream() //
        // predicate: .anyMatch(el -> second.contains(el));
        .anyMatch(second::contains);
  }

  public static <E> List<E> intersection(List<E> initial, List<E> verification) {
    Objects.requireNonNull(initial, "Initial list cannot be null");
    Objects.requireNonNull(verification, "Verification list cannot be null");
    return initial.stream() //
        .filter(el -> ListContains.contains(verification, el))
        .toList();
  }

  @Test
  public void testIntersection() {
    assertEquals(List.of(), intersection(List.of(4, 2), List.of(1, 3)));
    assertEquals(List.of(1), intersection(List.of(1, 2), List.of(1, 3)));
    assertEquals(List.of(2, 4), intersection(List.of(2, 4), List.of(1, 2, 4)));
  }

  @Test
  public void test() {
    assertFalse(hasIntersection(List.of(), List.of()));
    assertFalse(hasIntersection(List.of(), List.of(2)));
    assertFalse(hasIntersection(List.of(2), List.of()));
    assertFalse(hasIntersection(List.of(1), List.of(2)));

    assertTrue(hasIntersection(List.of(1), List.of(1)));
    assertTrue(hasIntersection(List.of(1), List.of(1, 2, 3)));
    assertTrue(hasIntersection(List.of(1, 2, 3), List.of(1)));
  }
}
