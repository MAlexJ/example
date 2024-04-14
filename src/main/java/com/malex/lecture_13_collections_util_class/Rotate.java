package com.malex.lecture_13_collections_util_class;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * Rotates the elements in the specified list by the specified distance. After calling this method,
 * the element at index i will be the element previously at index (i - distance) mod list. size()
 */
public class Rotate {

  @Test
  public void rotate() {
    // given
    List<String> list = Arrays.asList("one", "two", "three");

    // when
    Collections.rotate(list, 1);

    // then
    assertEquals("three", list.getFirst());
    assertEquals("two", list.getLast());
  }
}
