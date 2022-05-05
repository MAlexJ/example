package com.malex.lecture_13_generic.exampe_limited_types_extends;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

/**
 * Bounded Type Parameters
 *
 * <p>There may be times when you want to restrict the types that can be used as type arguments in a
 * parameterized type. For example, a method that operates on numbers might only want to accept
 * instances of Number or its subclasses. This is what bounded type parameters are for.
 */
@Log
public class LimitingTypes {

  public static void main(String[] args) {
    NaturalNumber<Integer> number = new NaturalNumber<>(11);
    log.info("Is even: " + number.isEven());

    number = new NaturalNumber<>(12);
    log.info("Is even: " + number.isEven());
  }
}

/**
 * Limiting the types you can use to instantiate a generic type, bounded type parameters allow you
 * to invoke methods defined in the bounds:
 */
@Log
@AllArgsConstructor
class NaturalNumber<T extends Integer> {
  private T num;

  boolean isEven() {
    StringBuilder sb =
        new StringBuilder("class: ")
            .append(num.getClass().getSimpleName())
            .append(", value=")
            .append(num);

    log.info(sb.toString());
    return num.intValue() % 2 == 0;
  }
}
