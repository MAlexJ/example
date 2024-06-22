package com.malex.lecture_4_algorithms.strings.avoid_inserting_duplicate;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/**
 * Avoid Inserting Duplicates in ArrayList in Java -
 * https://baeldung3.rssing.com/chan-58647577/latest-article1.php
 */
public class AvoidInsertingDuplicatesInArrayList extends AbstractUtils {

  private static final List<String> LIST = List.of("A", "B", "C", "D", "E");

  @Test
  public void applySetCollection() {
    // given
    Set<String> set = new HashSet<>(LIST);

    // when
    var newLetter = "E";
    boolean added = set.add(newLetter);
    assertFalse(added);

    // and
    var list = new ArrayList<>(set);

    // then
    assertEquals(LIST.size(), list.size());

    // and
    assertTrue(list.contains("E"));
  }
}
