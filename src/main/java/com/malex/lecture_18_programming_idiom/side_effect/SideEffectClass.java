package com.malex.lecture_18_programming_idiom.side_effect;

/**
 * A side effect is when a method call changes a class's state.
 *
 * <p>Here, doSomething(int arg0) has the side effect of changing the state variable.
 */
public class SideEffectClass {

  private int state = 0;

  /**
   * A side effect is anything a method does besides computing and returning a value. Any change of
   * instance or class field values is a side effect, as is drawing something on the screen, writing
   * to a file or a network connection.
   *
   * <p>Strictly speaking, a "function" is defined as not having side effects - which is why Java
   * uses the word "method" instead. A real function with no return value would be pointless.
   *
   * <p>Obviously, a method that does not have a return value must have some sort of side effect
   * that justifies its existence. Set methods are an example - the side effect is changing the
   * object's internal state.
   */
  public void doSomething(int arg0) {
    state += arg0;
  }
}
