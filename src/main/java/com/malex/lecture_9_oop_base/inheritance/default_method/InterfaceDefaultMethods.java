package com.malex.lecture_9_oop_base.inheritance.default_method;

import static com.malex.utils.AbstractUtils.printlnString;

import org.junit.Test;

public class InterfaceDefaultMethods implements DefaultInterface {

  @Test
  public void test() {
    defaultPrint(1);
  }
}

interface DefaultInterface {

  public default void defaultPrint(Integer num) {
    printlnString("value:", num.toString());
  }
}
