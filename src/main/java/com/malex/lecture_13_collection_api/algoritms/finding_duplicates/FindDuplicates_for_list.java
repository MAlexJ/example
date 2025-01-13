package com.malex.lecture_13_collection_api.algoritms.finding_duplicates;

import static junit.framework.TestCase.assertEquals;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

  /* Using HashSet and streams (Java 8+) */
  public <E> List<E> findDuplicates_stream_and_set(List<E> input) {
    // 1. Validate input parameters
    if (input.isEmpty()) return Collections.emptyList();

    // 2. Create the temporary set to retain the unique elementsl
    var uniqueElements = new HashSet<>();

    // 3. Apply a filter that excludes unique elements and add all others to the list.
    return input.stream()
        .filter(
            item -> {
              /*
               * Adds the specified element to this set if it is not already present
               *
               * Returns: true if this set did not already contain the specified element
               */
              // note: the element that is not added to the set is a duplicate
              return !uniqueElements.add(item);
            })
        .distinct()
        .toList();
  }

  /* Using Collections.frequency(Collection c, Object e) method */
  public static <E> List<E> findDuplicates_stream_and_collections_frequency(List<E> list) {
    // 1. Validate input parameters
    if (list.isEmpty()) return Collections.emptyList();

    // 2. To apply the condition that uses the 'frequency' method of the 'Collections' class.
    return list.stream()
        .distinct()
        .filter(entry -> Collections.frequency(list, entry) > 1)
        .toList();
  }

  /* Using Map to Count Occurrences */
  public static <E> List<E> findDuplicates_map_group_by_counting(List<E> list) {
    // 1. Validate input parameters
    if (list.isEmpty()) return Collections.emptyList();

    // 2. Apply the map group by elements and their number of occurrences
    Map<E, Long> mapOfElementsAndNumberOfOccurrences =
        list.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));

    // 2.
    return mapOfElementsAndNumberOfOccurrences.entrySet().stream()
        .filter(entry -> entry.getValue() > 1)
        .map(Map.Entry::getKey)
        .toList();
  }

  @Test
  public void findDuplicates_stream_and_set_test() {
    assertEquals(List.of(), findDuplicates_stream_and_set(List.of()));
    assertEquals(List.of(), findDuplicates_stream_and_set(List.of(1, 2, 3)));
    assertEquals(List.of(1), findDuplicates_stream_and_set(List.of(1, 2, 1)));
    assertEquals(List.of(1, 2), findDuplicates_stream_and_set(List.of(1, 2, 1, 3, 2)));
    assertEquals(List.of(1, 2, 3), findDuplicates_stream_and_set(List.of(1, 2, 1, 3, 2, 2, 3)));
  }

  @Test
  public void findDuplicates_map_group_by_counting_test() {
    assertEquals(List.of(), findDuplicates_map_group_by_counting(List.of()));
    assertEquals(List.of(), findDuplicates_map_group_by_counting(List.of(1, 2, 3)));
    assertEquals(List.of(1), findDuplicates_map_group_by_counting(List.of(1, 2, 1)));
    assertEquals(List.of(1, 2), findDuplicates_map_group_by_counting(List.of(1, 2, 1, 3, 2)));
    assertEquals(
        List.of(1, 2, 3), findDuplicates_map_group_by_counting(List.of(1, 2, 1, 3, 2, 2, 3)));
  }

  @Test
  public void findDuplicates_stream_and_collections_frequency_test() {
    assertEquals(List.of(), findDuplicates_stream_and_collections_frequency(List.of()));
    assertEquals(List.of(), findDuplicates_stream_and_collections_frequency(List.of(1, 2, 3)));
    assertEquals(List.of(1), findDuplicates_stream_and_collections_frequency(List.of(1, 2, 1)));
    assertEquals(
        List.of(1, 2), findDuplicates_stream_and_collections_frequency(List.of(1, 2, 1, 3, 2)));
    assertEquals(
        List.of(1, 2, 3),
        findDuplicates_stream_and_collections_frequency(List.of(1, 2, 1, 3, 2, 2, 3)));
  }
}
