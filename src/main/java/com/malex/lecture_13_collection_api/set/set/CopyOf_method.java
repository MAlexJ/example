package com.malex.lecture_13_collection_api.set.set;

import static junit.framework.TestCase.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class CopyOf_method {

  /*
   * Returns an unmodifiable Set containing the elements of the given Collection.
   * The given Collection must not be null, and it must not contain any null elements
   */
  @Test
  public void copyOf() {

    // given
    Set<Integer> mutableSetOfNumbers = new HashSet<>(Set.of(1, 2, 3, 4, 5));

    // when
    Set<Integer> unmodifiableSet = Set.copyOf(mutableSetOfNumbers);

    // then
    assertEquals(unmodifiableSet.size(), 5);

    // and
    mutableSetOfNumbers.add(6);
    assertEquals(mutableSetOfNumbers.size(), 6);

    // and
    assertEquals(unmodifiableSet.size(), 5);
  }
}
