package com.malex.lecture_15_Lambda_Functional_Interface.bi_funciton.custom;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

public class ThreeFunction_custom extends AbstractUtils {

  interface ThreeFunction<T, U, A, R> {
    R apply(T t, U u, A a);
  }

  @Test
  public void test() {
    ThreeFunction<Object, Integer, Double, String> function =
        (t, u, a) -> t.toString() + " " + u + " " + a;
    println(function.apply("Hello", 1, 2.3));
  }
}
