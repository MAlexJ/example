package com.malex.lecture_13_generic.example_generic_methods;

import lombok.extern.java.Log;

/**
 * Generic methods are methods that introduce their own type parameters. This is similar to
 * declaring a generic type, but the type parameter's scope is limited to the method where it is
 * declared. Static and non-static generic methods are allowed, as well as generic class
 * constructors.
 *
 * <p>The syntax for a generic method includes a list of type parameters, inside angle brackets,
 * which appears before the method's return type. For static generic methods, the type parameter
 * section must appear before the method's return type.
 */
@Log
public class SimpleGenericMethods {

  public static void main(String[] args) {
    // #1 first example
    int countInt = count(new Integer[] {1, 2, 3, 4, 45, 4, 23, 2, 5, 4, 11, 2}, 4);
    log.info("Count int: " + countInt);

    // #2 second example
    int countDouble = count(new Double[] {1.0, 2d, 3d, 4d, 45.11, 4d, 23d, 2d, 2.1}, 4d);
    log.info("Count double: " + countDouble);
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
