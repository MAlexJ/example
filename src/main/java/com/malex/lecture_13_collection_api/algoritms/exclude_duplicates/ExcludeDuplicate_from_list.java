package com.malex.lecture_13_collection_api.algoritms.exclude_duplicates;

import static junit.framework.TestCase.assertEquals;

import java.util.*;
import org.junit.Test;

public class ExcludeDuplicate_from_list {

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
    assertEquals(expectedList, excludeDuplicate_simple_hashSet(list));

    // case #2:  stream distinct
    assertEquals(expectedList, excludeDuplicate_stream_distinct(list));

    // case #3: use two setts and add method
    assertEquals(expectedList, excludeDuplicate_two_sets(list));

    // case #4: Using stream filter and intermediate the hashse
    assertEquals(expectedList, excludeDuplicate_stream_filter_temp_set(list));
  }

  public static <E> List<E> excludeDuplicate_simple_hashSet(List<E> list) {
    // Set is a collection that contains no duplicate elements.
    var uniqueSet = new HashSet<E>(list);
    return new ArrayList<>(uniqueSet);
  }

  /*
   * Use stream: `distinct()` method
   */
  public static <E> List<E> excludeDuplicate_stream_distinct(List<E> list) {
    return list.stream() //
        .distinct()
        .toList();
  }

  /*
   * Set returns a boolean whether a value already exists (true if it does not exist, false if it
   * already exists, see Set documentation)
   */
  public <E> List<E> excludeDuplicate_two_sets(List<E> list) {
    final var uniqueSet = new HashSet<E>();
    final var tempSet = new HashSet<E>();

    for (E item : list) {
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
  public static <T> List<T> excludeDuplicate_stream_filter_temp_set(Collection<T> collection) {
    Set<T> uniques = new HashSet<>();
    return collection.stream() //
        .filter(uniques::add)
        .toList();
  }
}
