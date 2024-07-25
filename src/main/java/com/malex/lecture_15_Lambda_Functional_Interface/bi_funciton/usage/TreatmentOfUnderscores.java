package com.malex.lecture_15_Lambda_Functional_Interface.bi_funciton.usage;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.utils.AbstractUtils;
import java.util.function.BiFunction;
import org.junit.Test;

/*
* Treatment of underscores ( JEP 302 )
*
* link: http://openjdk.org/jeps/302
*
* In many languages, it is common to use an underscore (_) to denote an unnamed lambda parameter
* (and similarly for method and exception parameters):

*  BiFunction<Integer, String, String> biss = (i, _) -> String.valueOf(i);

* This allows stronger static checking of unused arguments,
* and also allows multiple arguments to be marked as unused.
*/
public class TreatmentOfUnderscores extends AbstractUtils {

  @Test
  public void test() {
    BiFunction<Integer, String, String> biFunction = (i, _) -> String.valueOf(i);
    String result = biFunction.apply(1, null);
    assertThat(result).isEqualTo("1");
  }
}
