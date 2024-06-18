package com.malex.lecture_13_comparable_vs_comparator.comparable;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.TreeSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

public class ComparableBase extends AbstractUtils {

  @Test
  public void comparable() {
    var b = new Crs(1, "B");
    var a = new Crs(2, "A");

    var set = new TreeSet<Crs>() {};

    set.add(b);
    set.add(a);

    assertEquals("A", set.first().getName());
    assertEquals("B", set.last().getName());
  }

  /*
  java.lang.Comparable
   */
  @Data
  @AllArgsConstructor
  class Crs implements java.lang.Comparable<Crs> {

    private Integer id;

    private String name;

    @Override
    public int compareTo(Crs o) {
      return this.getName().compareTo(o.getName());
    }
  }
}
