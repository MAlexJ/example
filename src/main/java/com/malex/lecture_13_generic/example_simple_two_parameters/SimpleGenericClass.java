package com.malex.lecture_13_generic.example_simple_two_parameters;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

/** The example of using a simple generic class with two parameters */
@Log4j
public class SimpleGenericClass {
  public static void main(String[] args) {
    // example #1
    // use of Integer and String types
    TwoGen<Integer, String> twoGen = new TwoGen<>(12, "Text bla bla bla");
    log.debug("T: " + twoGen.getFirstParameter() + ", V: " + twoGen.getSecondParameter());
    twoGen.printType();

    // example #2
    // use of Double and Long types
    TwoGen<Double, Long> twoGen2 = new TwoGen<>(0.41, 1L);
    log.debug("T: " + twoGen2.getFirstParameter() + ", V: " + twoGen2.getSecondParameter());
    twoGen2.printType();
  }

  /** A simple class with two generics types */
  @Getter
  private static class TwoGen<T, V> {
    private T firstParameter;
    private V secondParameter;

    TwoGen(T first, V second) {
      this.firstParameter = first;
      this.secondParameter = second;
    }

    void printType() {
      log.debug("First type T: " + this.firstParameter);
      log.debug("First type V: " + this.secondParameter + "\n");
    }
  }
}
