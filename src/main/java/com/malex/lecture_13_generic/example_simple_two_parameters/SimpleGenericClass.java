package com.malex.lecture_13_generic.example_simple_two_parameters;

import lombok.Getter;
import lombok.extern.java.Log;

/** The example of using a simple generic class with two parameters */
@Log
public class SimpleGenericClass {

  public static void main(String[] args) {
    // example #1
    // use of Integer and String types
    TwoGen<Integer, String> twoGen = new TwoGen<>(12, "Text bla bla bla");
    log.info("T: " + twoGen.getFirstParameter() + ", V: " + twoGen.getSecondParameter());
    twoGen.printType();

    // example #2
    // use of Double and Long types
    TwoGen<Double, Long> twoGen2 = new TwoGen<>(0.41, 1L);
    log.info("T: " + twoGen2.getFirstParameter() + ", V: " + twoGen2.getSecondParameter());
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
      log.info("First type T: " + this.firstParameter);
      log.info("First type V: " + this.secondParameter + "\n");
    }
  }
}
