package com.malex.lecture_13_generic.raw_types;

import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

/**
 * * A raw type is the name of a generic class or interface without any type arguments. For example,
 * given the generic Box class: Box rawBox = new Box();
 */
@Log
public class RawTypesApp {

  /**
   * To create a parameterized type of Box<T>, you supply an actual type argument for the formal
   * type parameter T: Box<Integer> intBox = new Box<>(); If the actual type argument is omitted,
   * you create a raw type of Box<T>: Box rawBox = new Box(); Therefore, Box is the raw type of the
   * generic type Box<T>. However, a non-generic class or interface type is not a raw type.
   */
  public static void main(String[] args) {
    Box<Integer> boxInt = new Box<>();
    boxInt.setOb(123);
    log.info("Box<Integer> boxInt: " + boxInt);

    // this is Raw type
    Box box = new Box();
    box.setOb("Hello box");
    log.info("Box box: " + boxInt);
  }

  @Setter
  @ToString
  private static class Box<T> {
    private T ob;
  }
}
