package com.malex.lecture_15_Lambda_Functional_Interface.function.binary_functions.custom;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * Links to the constructor
 *
 * @author malex
 */
public class LinksToConstructor extends AbstractUtils {

  /** Functional interface */
  @FunctionalInterface
  private interface UserBuilderSPA {
    User createUser(int age, String name);
  }

  /** User class */
  public record User(int age, String name) {}

  @Test
  public void applyCustomFunctionInterface() {
    UserBuilderSPA builder = User::new;

    User alex = builder.createUser(21, "Alex");
    println(alex, "\n");

    User max = builder.createUser(20, "Max");
    println(max.toString());
  }
}
