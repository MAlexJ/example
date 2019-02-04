package com.malex.lecture_13_generic.example_simple_one_param;

import lombok.extern.log4j.Log4j;

/** The simple example of using generic with one parameter */
@Log4j
public class SimpleGenericClass {

  public static void main(String[] args) {
    // example #1:
    // use of the Integer type
    Gen<Integer> iOb = new Gen<>(192);
    log.debug("Gen<Integer> iOb: " + iOb.getObj());
    iOb.printType();

    // example #2
    // use of the String type
    Gen<String> sOb = new Gen<>("This is string.");
    log.debug("Gen<String> sOb: " + sOb);
    sOb.printType();
  }

  /** A simple generic class */
  private static class Gen<T> {

    private T value;

    Gen(T value) {
      this.value = value;
    }

    T getObj() {
      return this.value;
    }

    void printType() {
      log.debug("Type: " + this.value.getClass().getName() + "\n");
    }
  }
}
