package com.malex.lecture_13_collection_api;

import org.junit.Test;

public abstract class AbstractTestsUtils extends AbstractTest {

  @Test
  public void simpleTest() {
    String testDescription = getAnnotationDescription("simpleTest");
    print(">>>", "Execute test '", testDescription, "'");
    simpleTest(testDescription);
    print();
  }

  @Test
  public void baseFunctionalityTest() {
    String testDescription = getAnnotationDescription("baseFunctionalityTest");
    print(">>>", "Execute test '", testDescription, "'");
    baseFunctionalityTest(testDescription);
    print();
  }

  @Test
  public void additionalFunctionalityTest() {
    String testDescription = getAnnotationDescription("additionalFunctionalityTest");
    print(">>>", "Execute test '", testDescription, "'");
    additionalFunctionalityTest(testDescription);
    print();
  }

  public abstract void simpleTest(String description);

  public abstract void baseFunctionalityTest(String description);

  public abstract void additionalFunctionalityTest(String description);
}
