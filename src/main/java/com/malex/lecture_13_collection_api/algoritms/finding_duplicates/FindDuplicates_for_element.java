package com.malex.lecture_13_collection_api.algoritms.finding_duplicates;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class FindDuplicates_for_element {

  /*
   * Verify the presence of the specified element as a duplicate in the list
   */
  public static <E> boolean isDuplicateElementOnList(List<E> list, E element) {
    E temp = null;
    for (E e : list) {
      if (e.equals(element) && temp != null) {
        return true;
      }

      if (e.equals(element)) {
        temp = e;
      }
    }
    return false;
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
    // duplicates
    assertTrue(isDuplicateElementOnList(List.of(1, 2, 1), 1));

    // no duplicates
    assertFalse(isDuplicateElementOnList(List.of(), 1));
    assertFalse(isDuplicateElementOnList(List.of(1), 1));
    assertFalse(isDuplicateElementOnList(List.of(1, 2, 3), 1));
  }
}
