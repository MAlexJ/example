package com.malex.lecture_13_generic.type_erasure;

import static junit.framework.TestCase.assertNotNull;
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

  @Test
  public void boundObj() {
    var obj = new BoundObj();
    var boundedClass = new BoundedClass<BoundObj>(obj);
    assertNotNull(boundedClass.getVal());
  }

  @Data
  @AllArgsConstructor
  private static class BoundedClass<T extends java.lang.Comparable> {
    private T val;
  }

  private class BoundObj implements Comparable {

    @Override
    public int compareTo(Object o) {
      return this.compareTo(o);
    }
  }
}
