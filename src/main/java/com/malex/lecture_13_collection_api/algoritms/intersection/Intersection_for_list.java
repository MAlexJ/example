package com.malex.lecture_13_collection_api.algoritms.intersection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.lecture_13_collection_api.algoritms.contains.ListContains;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class Intersection_for_list {

  public static <E> boolean hasIntersection(List<E> first, List<E> second) {
    return first.stream() //
        // predicate: .anyMatch(el -> second.contains(el));
        .anyMatch(second::contains);
  }

  public static <E> List<E> intersection(List<E> initial, List<E> verification) {
    if (initial.isEmpty()) return initial;
    return initial.stream() //
        .filter(el -> ListContains.contains(verification, el))
        .toList();
  }

  public static <E> List<E> intersection_retainAll(List<E> initial, List<E> verification) {
    if (initial.isEmpty() || verification.isEmpty()) return Collections.emptyList();
    var initialList = new ArrayList<E>(initial);
    initialList.retainAll(verification);
    return initialList;
  }

  @Test
  public void testIntersection() {
    // empty list
    assertEquals(List.of(), intersection(List.of(), List.of()));
    assertEquals(List.of(), intersection(List.of(1, 3), List.of()));
    assertEquals(List.of(), intersection(List.of(), List.of(1, 3)));

    // no intersection
    assertEquals(List.of(), intersection(List.of(2), List.of(1)));
    assertEquals(List.of(), intersection(List.of(4, 2), List.of(1, 3)));

    // intersection
    assertEquals(List.of(1), intersection(List.of(1, 2), List.of(1, 3)));
    assertEquals(List.of(2, 4), intersection(List.of(2, 4), List.of(1, 2, 4)));
  }

  @Test
  public void testIntersection_retainAll() {
    // empty list
    assertEquals(List.of(), intersection_retainAll(List.of(), List.of()));
    assertEquals(List.of(), intersection_retainAll(List.of(1, 3), List.of()));
    assertEquals(List.of(), intersection_retainAll(List.of(), List.of(1, 3)));

    // no intersection
    assertEquals(List.of(), intersection_retainAll(List.of(2), List.of(1)));
    assertEquals(List.of(), intersection_retainAll(List.of(4, 2), List.of(1, 3)));

    // intersection
    assertEquals(List.of(1), intersection_retainAll(List.of(1, 2), List.of(1, 3)));
    assertEquals(List.of(2, 4), intersection_retainAll(List.of(2, 4), List.of(1, 2, 4)));
  }

  @Test
  public void testHasIntersection() {
    assertFalse(hasIntersection(List.of(), List.of()));
    assertFalse(hasIntersection(List.of(), List.of(2)));
    assertFalse(hasIntersection(List.of(2), List.of()));
    assertFalse(hasIntersection(List.of(1), List.of(2)));

    assertTrue(hasIntersection(List.of(1), List.of(1)));
    assertTrue(hasIntersection(List.of(1), List.of(1, 2, 3)));
    assertTrue(hasIntersection(List.of(1, 2, 3), List.of(1)));
  }
}
