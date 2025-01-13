package com.malex.lecture_13_collection_api.algoritms.contains;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class ListContains {

  /*
   * Contains only one element
   */
  public static <E> boolean contains(List<E> list, E element) {
    //  WTF: boolean contains = list.contains(element);
    return list.stream().anyMatch(e -> e.equals(element));
  }

  /*
   * Contains only one
   */
  public static <E> boolean containsOnlyOne(List<E> list, List<E> subList) {
    if (list.isEmpty() || subList.isEmpty()) return false;

    // find intersection
    var initList = new ArrayList<>(list);
    initList.retainAll(subList);

    return initList.size() == 1;
  }

  /*
   * Contains at least one
   */
  public static <E> boolean containsAtLeastOne(List<E> list, List<E> subList) {
    if (list.isEmpty() || subList.isEmpty()) return false;

    var tempSubSet = new HashSet<>(subList);
    // intersection

    // intersection.size() >= 1

    return true;
  }

  /*
   * Contains all
   */
  public static <E> boolean containsAll(List<E> list, List<E> subList) {
    // 1.Exclude duplicates, convert sub-list to sub-set
    var tempSubSet = new HashSet<>(subList);

    // 2. Find intersection between list and temp sub-set
    var intersection = list.stream().filter(tempSubSet::contains).collect(Collectors.toSet());

    // 3. the number of elements in the intersection should be the same
    return intersection.size() == tempSubSet.size();
  }

  /*
   * No match
   */
  public static <E> boolean noMatch(List<E> list, List<E> subList) {
// 1.
    var tempSubSet = new HashSet<>(subList);
   // 2.
    var intersection = list.stream().filter(tempSubSet::contains).collect(Collectors.toSet());
// 3.
    return intersection.isEmpty();
  }

  @Test
  public void containsAllTest() {
    // true
    assertTrue(containsAll(List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4, 5)));
    assertTrue(containsAll(List.of(1, 2, 3, 4, 5), List.of(1, 2, 3)));
    assertTrue(containsAll(List.of(1, 2, 3, 4, 5), List.of(4)));
    assertTrue(containsAll(List.of(), List.of()));

    assertFalse(containsAll(List.of(1, 2, 4), List.of(1, 2, 3)));
    assertFalse(containsAll(List.of(1), List.of(1, 2, 3)));
    assertFalse(containsAll(List.of(1, 2), List.of(3, 4, 5)));
  }

  @Test
  public void containsOnlyOneTest() {
    // empty
    assertFalse(containsOnlyOne(Collections.emptyList(), Collections.emptyList()));
    assertFalse(containsOnlyOne(Collections.emptyList(), List.of(1)));
    assertFalse(containsOnlyOne(List.of(1), new ArrayList<>()));

    // no intersection
    assertFalse(containsOnlyOne(List.of(1), List.of(2)));
    assertFalse(containsOnlyOne(List.of(1), List.of(2, 3, 5)));
    assertFalse(containsOnlyOne(List.of(1, -1, 0), List.of(2, 3, 5)));

    // more than one intersection
    assertFalse(containsOnlyOne(List.of(1, 2), List.of(1, 2)));
    //    assertEquals(false, containsOnlyOne(List.of(1, 2, 3), List.of(1, -1,1)));

    //  intersection
    assertTrue(containsOnlyOne(List.of(1), List.of(1, 2)));
    assertTrue(containsOnlyOne(List.of(1, 3, 4), List.of(1, 2)));
    assertTrue(containsOnlyOne(List.of(1, 3, 4, 5), List.of(3)));
  }
}
