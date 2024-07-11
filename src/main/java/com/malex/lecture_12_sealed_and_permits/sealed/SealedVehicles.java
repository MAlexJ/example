package com.malex.lecture_12_sealed_and_permits.sealed;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * Sealed Classes and Interfaces in Java:
 *
 * <p>link: https://www.baeldung.com/java-sealed-classes-interfaces#creation
 *
 * <p>link: https://habr.com/ru/articles/477654/
 */
public class SealedVehicles extends AbstractUtils {

  @Test
  public void test() {
    Vehicle car = new Car();
    car.drive();

    Vehicle truck = new Truck();
    truck.drive();
  }

  /** */
  private sealed interface Vehicle {

    void drive();

    default void printClassName() {
      String className = this.getClass().getName();
      printlnString("Subclass:", className.substring(className.indexOf("$") + 1));
    }
  }

  private final class Car implements Vehicle {

    @Override
    public void drive() {
      printClassName();
    }
  }

  private record Truck() implements Vehicle {
    @Override
    public void drive() {
      printClassName();
    }
  }
}
