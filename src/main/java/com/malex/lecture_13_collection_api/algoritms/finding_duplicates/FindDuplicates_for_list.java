package com.malex.lecture_13_collection_api.algoritms.finding_duplicates;

import static junit.framework.TestCase.assertEquals;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

/*
 * Explanation of Key Terms
 *
 * Duplicates: Items that appear more than once in a collection.
 * HashSet: Used to store unique elements.
 * The add() method returns false if an element is already present, making it useful for detecting duplicates.
 *
 * Streams: A sequence of elements supporting functional-style operations to process collections in Java.
 */
public class FindDuplicates_for_list {

  private final List<Integer> numbers = List.of(1, 1, 2, 1, 3, 4, 5, 5, 6, 7, 8, 8);

  /*
   * Expected numbers
   */
  private final List<Integer> expectedList = List.of(1, 5, 8);
  private final Set<Integer> expectedSet = Set.of(1, 5, 8);

  @Test
  public void findDuplicateTest() {
    // case #0 : simple
    assertEquals(expectedSet, findDuplicate_simple(numbers));

    // case #1 : Hashset and stream
    assertEquals(expectedList, findDuplicates_stream_and_set(numbers));

    // case #2 : Collections.frequency
    assertEquals(expectedList, findDuplicatesLambda(numbers));

    // case #3
    assertEquals(expectedList, findDuplicatesLambda(numbers));

    // case #4
    assertEquals(expectedList, findDuplicatesMapCountOccurrences(numbers));
  }

  private <E> Set<E> findDuplicate_simple(List<E> input) {
    // 1. set of unique elements
    var tempSet = new HashSet<E>();
    // 2. result set og duplicates
    var duplicateSet = new HashSet<E>();
    // 3. for each of the elements
    for (E i : input) {
      // note: the element that is not added to the set is a duplicate
      boolean isDuplicate = !tempSet.add(i);
      if (isDuplicate) {
        duplicateSet.add(i);
      }
    }
    return duplicateSet;
  }

  /* Using HashSet and streams (Java 8+) */
  private List<Integer> findDuplicates_stream_and_set(List<Integer> input) {
    // Find duplicates using streams
    Set<Integer> uniqueItems = new HashSet<>();

    return input.stream()
        .filter(
            item -> {
              /*
               * Adds the specified element to this set if it is not already present
               *
               * Returns: true if this set did not already contain the specified element
               */
              // note: the element that is not added to the set is a duplicate
              return !uniqueItems.add(item);
            })
        .distinct()
        .toList();
  }

  /* Using Collections.frequency(Collection c, Object e) method */
  private List<Integer> findDuplicatesLambda(List<Integer> list) {
    return list.stream()
        .distinct()
        .filter(entry -> Collections.frequency(list, entry) > 1)
        .toList();
  }

  /* Using Map to Count Occurrences */
  private List<Integer> findDuplicatesMapCountOccurrences(List<Integer> input) {
    Map<Integer, Long> counts =
        input.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
    return counts.entrySet().stream()
        .filter(entry -> entry.getValue() > 1)
        .map(Map.Entry::getKey)
        .toList();
  }
}
