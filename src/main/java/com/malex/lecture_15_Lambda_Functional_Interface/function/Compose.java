package com.malex.lecture_15_Lambda_Functional_Interface.function;

import static junit.framework.TestCase.assertEquals;

import java.util.function.Function;
import org.junit.Test;

/*
 * compose(..) - applies before function to its input, and then applies this function to result.
 *
 * Returns a composed function that first applies the before function
 * to its input, and then applies this function to the result.
 */
public class Compose {

  @Test
  public void composeSequence() {
    String compose =
        oneFunction() // "1"
            .compose(twoFunction()) // "2"
            .compose(threeFunction()) // "3"
            .compose(fourFunction()) // "4"
            .apply("0"); // "0"

    assertEquals("04321", compose);
  }

  @Test
  public void andThenSequence() {
    String compose =
        oneFunction() // "1"
            .andThen(twoFunction()) // "2"
            .andThen(threeFunction()) // "3"
            .andThen(fourFunction()) // "4"
            .apply("0"); // "0"

    assertEquals("01234", compose);
  }

  private Function<String, String> oneFunction() {
    return s -> s + "1";
  }

  private Function<String, String> twoFunction() {
    return s -> s + "2";
  }

  private Function<String, String> threeFunction() {
    return s -> s + "3";
  }

  private Function<String, String> fourFunction() {
    return s -> s + "4";
  }
}
