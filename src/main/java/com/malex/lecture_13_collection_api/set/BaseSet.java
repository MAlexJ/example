package com.malex.lecture_13_collection_api.set;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import java.time.DayOfWeek;
import java.util.*;
import org.junit.Test;

/** In Java, the Set interface represents a collection that does not allow duplicate elements. */
public class BaseSet extends AbstractBase {

  @Test
  public void allImpl() {
    Set<String> hashSet = new HashSet<>();
    Set<String> treeSet = new TreeSet<>();
    Set<String> linkedHashSet = new LinkedHashSet<>();
    Set<DayOfWeek> enumSet = EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY);
    println(enumSet);
  }
}
