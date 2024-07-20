package com.malex.lecture_23_Principles_of_Software_Development.solid.open_closed;

import com.malex.utils.AbstractUtils;
import java.util.List;
import org.junit.Test;

/**
 * Open Closed Principle principle
 *
 * <p>The Open Closed Principle principle states that software entities like class, modules,
 * functions, etc.; should be able to extend a class behavior without modifying it
 *
 * <p>The open/closed principle is generally achieved by using **inheritance** and polymorphism
 *
 * <p>link: https://www.geeksforgeeks.org/open-closed-principle-in-java-with-examples/
 */
public class GeeksForGeeksSamples extends AbstractUtils {

  private interface GeoObjects {
    double getVolume();
  }

  private record Cuboid(double length, double breadth, double height) implements GeoObjects {
    @Override
    public double getVolume() {
      return length * breadth * height;
    }
  }

  private record Sphere(double radius) implements GeoObjects {
    @Override
    public double getVolume() {
      return radius;
    }
  }

  record Application(List<GeoObjects> objects) {
    public double getTotalVolume() {
      double sum = 0;
      for (GeoObjects object : objects) {
        sum += object.getVolume();
      }
      return sum;
    }
  }

  @Test
  public void test() {
    var first = new Cuboid(1.0, 2.0, 3.0);
    var second = new Cuboid(1.0, 2.0, 3.0);
    var third = new Sphere(1);
    var application = new Application(List.of(first, second, third));
    println("total: ", application.getTotalVolume());
  }
}
