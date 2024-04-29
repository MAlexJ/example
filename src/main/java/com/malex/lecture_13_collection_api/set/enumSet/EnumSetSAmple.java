package com.malex.lecture_13_collection_api.set.enumSet;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import java.time.DayOfWeek;
import java.util.EnumSet;
import org.junit.Test;

public class EnumSetSAmple extends AbstractBase {

  @Test
  public void test() {
    // Creating an EnumSet with All Enum Constants:
    EnumSet<DayOfWeek> allDays = EnumSet.allOf(DayOfWeek.class);
    println(allDays);
  }
}
