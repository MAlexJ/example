package com.malex.lecture_13_generic.example_generic_methods;

import lombok.extern.log4j.Log4j;

@Log4j
public class SimpleGenericMethods {

  public static void main(String[] args) {
    // #1 first example
    int countInt = count(new Integer[] {1, 2, 3, 4, 45, 4, 23, 2, 5, 4, 11, 2}, 4);
    log.debug("Count int: " + countInt);

    // #2 second example
    int countDouble = count(new Double[] {1.0, 2d, 3d, 4d, 45.11, 4d, 23d, 2d, 2.1}, 4d);
    log.debug("Count double: " + countDouble);
  }

  /** Counts the number of occurrences of elem in anArray. */
  private static <T extends Number> int count(T[] anArray, T elem) {
    int cnt = 0;
    for (T e : anArray) {
      if (e.equals(elem)) {
        ++cnt;
      }
    }
    return cnt;
  }
}
