package com.malex.lecture_4_arrays;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import org.junit.Test;

public class ArraysSample extends AbstractUtils {

  @Test
  public void sortArrayTest() {
    // given
    Entity[] entities =
        new Entity[] {new Entity("Anna", 24), new Entity("Max", 19), new Entity("Zak", 36)};

    // when
    Arrays.sort(entities, (o1, o2) -> Integer.compare(o1.count(), o2.count()));
    println("Sort:", Arrays.toString(entities));

    // then
    assertEquals(entities[0].name(), "Max");
  }

  private record Entity(String name, int count) {}
}
