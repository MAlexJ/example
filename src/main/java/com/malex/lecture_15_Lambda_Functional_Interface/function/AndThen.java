package com.malex.lecture_15_Lambda_Functional_Interface.function;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.function.Function;
import org.junit.Test;

/*
* andThan(..) - applies the after function to the result
*
* Returns a composed function that first applies this function to its input,
* and then applies the after function to the result.
 */
public class AndThen extends AbstractUtils {

  @Test
  public void andThen() {
    Function<String, Integer> calculateLength =
        str -> {
          int length = str.length();
          println("1. calculate length:", length);
          return length;
        };

    Function<Integer, String> generateSequence =
        num -> {
          String valueOf = String.valueOf(num);
          println("2. generate sequence:", valueOf);
          return valueOf;
        };

    Function<String, Double> parseString =
        str -> {
          double parseDouble = Double.parseDouble(str);
          println("3. parse string:", parseDouble);
          return parseDouble;
        };

    Double number =
        calculateLength //
            .andThen(generateSequence)
            .andThen(parseString)
            .apply("Hello World");

    assertThat(number).isEqualTo(11.0);
  }

  @Test
  public void simpleTest() {
    // given
    int number = 4;
    Function<String, Integer> fn1 = Integer::parseInt;
    Function<Integer, Integer> fn2 = num -> num * num;
    Function<Integer, String> fn3 = num -> num + "_java";

    // when
    String result =
        fn1.andThen(fn2) //
            .andThen(fn3) //
            .apply(Integer.toString(number));

    // then
    assertEquals("16_java", result);
  }
}
