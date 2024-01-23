package com.malex.lecture_29_algorithm;

import static org.junit.Assert.assertArrayEquals;

import com.malex.lecture_29_algorithm.impl.SortSelection;
import org.junit.Test;

public class SortSelectionTest {
  @Test
  public void test() {
    var algorithm = new SortSelection();
    assertArrayEquals(new int[] {-3, -2, 0, 1}, algorithm.selectionSort(new int[] {-2, 0, 1, -3}));
    assertArrayEquals(new int[] {1, 2, 3}, algorithm.selectionSort(new int[] {3, 2, 1}));
    assertArrayEquals(new int[] {1, 2, 3}, algorithm.selectionSort(new int[] {1, 2, 3}));
    assertArrayEquals(new int[] {-1, 0, 0, 0}, algorithm.selectionSort(new int[] {0, 0, -1, 0}));
  }
}
