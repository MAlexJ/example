package com.malex.lecture_13_collection_api.set.set;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import java.time.DayOfWeek;
import java.util.*;
import org.junit.Test;

/** In Java, the Set interface represents a collection that does not allow duplicate elements. */
public class BaseSetInitialization extends AbstractBase {

  @Test
  public void initialization() {
    // 1. HashSet
    Set<String> hashSet = new HashSet<>();

    // 2. TreeSet
    Set<String> treeSet = new TreeSet<>();

    // 3. LinkedHashSet
    Set<String> linkedHashSet = new LinkedHashSet<>();

    // 4. EnumSet
    Set<DayOfWeek> enumSet = EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY);
    println(enumSet);

    // 5. Returns an unmodifiable set
    Set<Integer> setOf = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
  }
}
