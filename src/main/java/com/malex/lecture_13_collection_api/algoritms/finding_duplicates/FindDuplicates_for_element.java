package com.malex.lecture_13_collection_api.algoritms.finding_duplicates;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Test;

public class FindDuplicates_for_element {

  /*
   * Verify the presence of the specified element as a duplicate in the list
   */
  public static <E> boolean isDuplicate_simple(List<E> list, E element) {
    // 1. Validate input parameters
    if (list == null || element == null || list.isEmpty()) return false;

    // 2. Create a temporary variable for the first occurrence of an element
    E temp = null;

    // 3. Iterate through each element of the list to search for duplicate elements
    for (E e : list) {

      // 3.1 If 'temp' is not empty, and we find it again, that means we have found duplicate
      if (e.equals(element) && temp != null) {
        return true;
      }

      // 3.2. The first occurrence of an element in a list
      if (e.equals(element)) {
        temp = e;
      }
    }
    return false;
  }

  /*
   * The element occurs multiple times in the list.
   */
  public static <E> boolean isDuplicate_map_with_groupingBy(List<E> list, E element) {
    // 1. Validate input parameters
    if (list == null || element == null || list.isEmpty()) return false;

    // 2. Create a map where the key is an element from the list, and the value is the number of its
    // occurrences
    Map<E, Long> mapOfElementsAndNumberOfOccurrences =
        list.stream() //
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

    // 3. Get the number of occurrences of an element in a list by its value
    return Optional.ofNullable(mapOfElementsAndNumberOfOccurrences.get(element))
        // 3.1. The element can be duplicated when its number is greater than one.
        .filter(count -> count > 1)
        .isPresent();
  }

  /*
   * Find the number of occurrences of an element in a list
   */
  public static <E> int occurrencesOfElementInList(List<E> list, E element) {
    int occurrences = 0;
    for (E e : list) {
      if (e.equals(element)) {
        occurrences++;
      }
    }
    return occurrences;
  }

  @Test
  public void occurrencesOfElementInListTest() {
    assertEquals(0, occurrencesOfElementInList(Collections.emptyList(), 0));
    assertEquals(0, occurrencesOfElementInList(List.of(1, 2, 3), 0));
    assertEquals(1, occurrencesOfElementInList(List.of(1, 2, 3), 1));
    assertEquals(2, occurrencesOfElementInList(List.of(1, 2, 3, 1), 1));
    assertEquals(3, occurrencesOfElementInList(List.of(1, 2, 1, 3, 1), 1));
  }

  @Test
  public void isDuplicateElementOnListTest() {
    // Duplicates found in the list
    assertTrue(isDuplicate_simple(List.of(1, 2, 1), 1));
    assertTrue(isDuplicate_simple(List.of(1, 2, 1, -1, 2, 1), 1));

    // Duplicates not found in the list
    assertFalse(isDuplicate_simple(null, 1));
    assertFalse(isDuplicate_simple(Collections.emptyList(), 1));
    assertFalse(isDuplicate_simple(List.of(), null));
    assertFalse(isDuplicate_simple(List.of(), 1));
    assertFalse(isDuplicate_simple(List.of(1), 1));
    assertFalse(isDuplicate_simple(List.of(1, 2, 3), 1));
    assertFalse(isDuplicate_simple(List.of(1, 2, 3), 4));
  }

  @Test
  public void isDuplicate_map_with_groupingBy_test() {
    // Duplicates found in the list
    assertTrue(isDuplicate_map_with_groupingBy(List.of(1, 2, 1), 1));
    assertTrue(isDuplicate_map_with_groupingBy(List.of(1, 2, 1, -1, 2, 1), 1));

    // Duplicates not found in the list
    assertFalse(isDuplicate_map_with_groupingBy(null, 1));
    assertFalse(isDuplicate_map_with_groupingBy(Collections.emptyList(), 1));
    assertFalse(isDuplicate_map_with_groupingBy(List.of(), null));
    assertFalse(isDuplicate_map_with_groupingBy(List.of(), 1));
    assertFalse(isDuplicate_map_with_groupingBy(List.of(1), 1));
    assertFalse(isDuplicate_map_with_groupingBy(List.of(1, 2, 3), 1));
    assertFalse(isDuplicate_map_with_groupingBy(List.of(1, 2, 3), 4));
  }
}
