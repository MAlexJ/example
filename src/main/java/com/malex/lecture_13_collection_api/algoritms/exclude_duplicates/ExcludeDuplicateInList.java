package com.malex.lecture_13_collection_api.algoritms.exclude_duplicates;

import static junit.framework.TestCase.assertEquals;

import java.util.*;
import org.junit.Test;

public class ExcludeDuplicateInList {

  /*
   * Actual list with duplicates
   */
  private final List<Integer> list = List.of(1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 8);

  /*
   * Expected
   */
  private final List<Integer> expectedList = List.of(1, 2, 3, 4, 5, 6, 7, 8);

  @Test
  public void test() {

    // case #1: simple with hashset
    assertEquals(expectedList, simpleWithHashSet(list));

    // case #2:  stream distinct
    assertEquals(expectedList, streamDistinct(list));

    // case #3: use two setts and add method
    assertEquals(expectedList, twoSets(list));

    // case #4: Using stream filter and intermediate the hashse
    assertEquals(expectedList, streamFilterWithIntermediateSet(list));
  }

  private List<Integer> simpleWithHashSet(List<Integer> list) {
    // Set is a collection that contains no duplicate elements.
    var uniqueSet = new HashSet<>(list);
    return new ArrayList<>(uniqueSet);
  }

  /*
   * Use stream: `distinct()` method
   */
  private List<Integer> streamDistinct(List<Integer> list) {
    return list.stream() //
        .distinct()
        .toList();
  }

  /*
   * Set returns a boolean whether a value already exists (true if it does not exist, false if it
   * already exists, see Set documentation)
   */
  private List<Integer> twoSets(List<Integer> list) {
    final var uniqueSet = new HashSet<Integer>();
    final var tempSet = new HashSet<Integer>();

    for (Integer item : list) {
      /*
       * When new element is added to the set, the method returns true if it doesn't exist, false if it already exists
       */
      if (tempSet.add(item)) {
        uniqueSet.add(item);
      }
    }

    return new ArrayList<>(uniqueSet);
  }

  /*
   * Using stream filter and intermediate the hashset
   * Set returns a boolean whether a value already exists (true if it does not
   * exist, false if it already exists, see Set documentation)
   */
  private <T> List<T> streamFilterWithIntermediateSet(Collection<T> collection) {
    Set<T> uniques = new HashSet<>();
    return collection.stream() //
        .filter(uniques::add)
        .toList();
  }
}
