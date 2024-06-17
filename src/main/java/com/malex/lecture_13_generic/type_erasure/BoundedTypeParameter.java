package com.malex.lecture_13_generic.type_erasure;

import static junit.framework.TestCase.assertTrue;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

/** Bounded type parameter */
public class BoundedTypeParameter {

  @Test
  public void boundedTypeParameter() {

    // 1. raw type
    var boundedClass = new BoundedClass("Bound");
    /*
    The Java compiler replaces the bounded type parameter T with the first bound class, Comparable:
     */
    Comparable comparable = boundedClass.getVal();
    assertTrue(comparable instanceof Comparable);

    // 2. bounded type Comparable/String parameter
    var stringBoundedClass = new BoundedClass<String>("Str");
    String val = stringBoundedClass.getVal();
    assertTrue(val instanceof String);
  }

  @Data
  @AllArgsConstructor
  private static class BoundedClass<T extends Comparable> {
    private T val;
  }
}
