package com.malex.lecture_13_collection_api.algoritms.finding_duplicates;

import static junit.framework.TestCase.assertEquals;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class FindDuplicates_for_set {

  public static <E> Set<E> findDuplicate_simple(List<E> input) {
    // 1. Validate input parameters
    if (input.isEmpty()) return Collections.emptySet();

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

  @Test
  public void findDuplicate_simple_test() {
    assertEquals(Set.of(), findDuplicate_simple(List.of()));
    assertEquals(Set.of(), findDuplicate_simple(List.of(1, 2, 3)));
    assertEquals(Set.of(1), findDuplicate_simple(List.of(1, 2, 1)));
    assertEquals(Set.of(1, 2), findDuplicate_simple(List.of(1, 2, 1, 3, 2)));
    assertEquals(Set.of(1, 2, 3), findDuplicate_simple(List.of(1, 2, 1, 3, 2, 2, 3)));
  }
}
