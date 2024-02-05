package com.malex.lecture_18_programming_idiom.covariance_contravariance_and_invariance;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import org.junit.Test;

/**
 * Arrays Are Covariant
 *
 * <p>Tutorial: https://dzone.com/articles/covariance-and-contravariance
 *
 * <p>Arrays are said to be covariant which basically means that, given the subtyping rules of Java,
 * an array of type T[] may contain elements of type T or any subtype of T
 */
public class ArraysAreCovariant extends AbstractUtils {

  /** The array of type T[] may contain elements of type T or any subtype of T */
  @Test
  public void subtypeSample() {
    /*
     * Number
     * < Integer
     * < Byte
     * ....
     * < Double
     */
    Number[] numbers = new Number[5];

    // The array of type Number
    // Integer, Byte, Double ...  subtype of Number

    numbers[0] = Integer.valueOf("1");
    numbers[1] = Byte.valueOf("12");
    numbers[2] = Double.valueOf("3.14");

    print(Arrays.toString(numbers));
  }

  /**
   * Subtyping rules of Java also state that an array S[] is a subtype of the array T[] if S is a
   * subtype of T
   */
  @Test
  public void arraySample() {
    /*
     * Object < Number < Integer
     */
    Integer[] integers = {1, 2, 3, 4, 5};
    Number[] numbers = integers;
    Object[] objects = numbers;

    print(Arrays.toString(objects));
  }

  @Test
  public void simple() {
    /*
     * Object < Number < Integer
     */
    Object[] objects = new Object[5];
    objects[0] = Integer.valueOf("12");
    objects[1] = "12";
    objects[2] = 3.12;
    objects[3] = Boolean.TRUE;

    print(Arrays.toString(objects));
  }
}
