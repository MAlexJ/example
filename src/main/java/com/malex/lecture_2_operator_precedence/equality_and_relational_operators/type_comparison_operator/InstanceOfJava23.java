package com.malex.lecture_2_operator_precedence.equality_and_relational_operators.type_comparison_operator;

import com.malex.utils.AbstractUtils;

public class InstanceOfJava23 extends AbstractUtils {

  public static void main(String[] args) {
    printlnString("is Integer - " + isInteger(2.0));
  }

  private static boolean isInteger(double d) {
    return d instanceof long;
  }
}
