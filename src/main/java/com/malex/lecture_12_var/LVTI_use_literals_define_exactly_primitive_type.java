package com.malex.lecture_12_var;

/*
 * Use literals to help var define exactly the primitive type  (int, long, float, double)
 *
 * link: https://habr.com/ru/articles/438206/
 *
 * Without using literals for primitive types, we can discover that expected and assumed types may differ.
 * This is caused by the implicit types that are used by var-variables.
 */
public class LVTI_use_literals_define_exactly_primitive_type {

  // case 1:
  private void method_1() {
    boolean flag = true; // this is of type boolean
    char a = 'a'; // this is of type char

    var flagBoolean = true; // this is inferred as boolean
    var aChar = 'a'; // this is inferred as char
  }

  /*
   * case 2:
   *
   * All four variables will be output as int. To correct this behavior we need to use Java literals:
   */
  private void default_upcast_to_int() {
    int intNum = 20; // this is of type int
    long longNum = 20; // this is of type long
    float floatNum = 20; // this is of type float, 20.0
    double doubleNum = 20; // this is of type double, 20.0

    // AVOID
    var intN = 20; // this is inferred as int
    var longN = 20; // this is inferred as int
    var floatN = 20; // this is inferred as int
    var doubleN = 20; // this is inferred as int

    // PREFER
    var intNumber = 20; // this is inferred as int
    var longNumber = 20L; // this is inferred as long
    var floatNumber = 20F; // this is inferred as float, 20.0
    var doubleNumber = 20D; // this is inferred as double, 20.0
  }

  /*
   * case 3:
   *
   * But what happens if we declare a number with the decimal point?
   *
   * Avoid this if you expect to get a variable of type float:
   */
  private void default_double() {
    // AVOID, IF THIS IS A FLOAT
    var floatNumb = 20.5; // this is inferred as double

    // PREFER, IF THIS IS A FLOAT
    var floatNumber = 20.5F; // this is inferred as float
  }
}
