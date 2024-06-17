package com.malex.lecture_13_generic.type_erasure;

import static junit.framework.TestCase.assertTrue;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

/** 2. unbounded type parameter */
public class UnboundedTypeParameter {

  @Test
  public void unboundedTypeParameter() {
    // Java compiler replaces it with Object:
    UnboundedNode simpleObject = new UnboundedNode(new Object());
    Object returnObj = simpleObject.getVal();
    assertTrue(returnObj instanceof Object);

    // or set type
    UnboundedNode<String> stringUnboundedNode = new UnboundedNode<>("Hello!");
    assertTrue(stringUnboundedNode.getVal() instanceof String);
    assertTrue(stringUnboundedNode.getVal() instanceof Object);
  }

  /**
   * Because the type parameter T is unbounded, the Java compiler replaces it with Object:
   *
   * @param <T>
   */
  @Data
  @AllArgsConstructor
  private static class UnboundedNode<T> {
    private T val;
  }
}
