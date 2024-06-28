package com.malex.lecture_13_collection_api;

import org.junit.Test;

public abstract class AbstractTestUtils extends AbstractTest {

  public abstract void test(String description);

  @Test
  public void test() {
    String testDescription = getAnnotationDescription("test");
    print(">>>", "Execute test '", testDescription, "'");
    test(testDescription);
    print();
  }
}
