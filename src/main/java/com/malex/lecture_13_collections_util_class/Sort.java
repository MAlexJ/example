package com.malex.lecture_13_collections_util_class;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class Sort extends AbstractUtils {

  @Test
  public void sortSimpleElements() {
    // given
    var list = new ArrayList<>(List.of("C", "X", "A", "R"));

    // when
    Collections.sort(list);
    println(list);

    // then
    assertEquals(list.getFirst(), "A");
    assertEquals(list.getLast(), "X");
  }

  /**
   * Sorts the specified list according to the order induced by the specified comparator. All
   * elements in the list must be mutually comparable using the specified comparator
   */
  @Test
  public void sortList() {
    // given
    var list =
        new ArrayList<Entity>() {
          {
            add(new Entity(1, "C"));
            add(new Entity(-1, "A"));
            add(new Entity(8, "F"));
            add(new Entity(5, "S"));
            add(new Entity(3, "W"));
          }
        };

    // when
    Collections.sort(list, Comparator.comparing(Entity::name));

    // then
    println(list);
    assertEquals(list.getFirst().name(), "A");
    assertEquals(list.getLast().name(), "W");
  }

  private record Entity(int id, String name) {}
}
