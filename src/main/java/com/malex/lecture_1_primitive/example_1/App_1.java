package com.malex.lecture_1_primitive.example_1;

import org.apache.log4j.Logger;

/** Created by admin on 29.01.2015. */
public class App_1 {

  private static final Logger LOG = Logger.getLogger(App_1.class);

  public static void main(String[] args) {
    int a = 3;
    int b = 5;

    a = a + b; // a = 8, b = 5
    b = a - b; // a = 8, b = 3
    a = a - b; // a = 5, b = 3

    LOG.debug("a = " + a);
    LOG.debug("b = " + b);
  }
}
