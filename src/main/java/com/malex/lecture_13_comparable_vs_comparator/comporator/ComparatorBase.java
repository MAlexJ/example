package com.malex.lecture_13_comparable_vs_comparator.comporator;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import org.junit.Test;

/** java.util.Comparator is FunctionalInterface */
public class ComparatorBase extends AbstractUtils {

  @Test
  public void functionalInterface() {
    List<String> list = new ArrayList<>(List.of("A", "B", "C", "D"));
    list.sort(Comparator.reverseOrder());
    println("Comparator.reverseOrder:", list);

    list.sort(Comparator.naturalOrder());
    println("Comparator.naturalOrder:", list);
  }

  @Test
  public void collectionsOrLisSort() {
    var cars =
        new ArrayList<Car>() {
          {
            add(new Car(2017, "BMV", 300));
            add(new Car(2019, "AUDI", 320));
            add(new Car(2024, "MAZDA", 250));
          }
        };

    /*
    Compiler error: reason: no instance(s) of type variable(s) T exist so that Car conforms to Comparable<? super T>
    Collections.sort(cars);
     */
    Collections.sort(cars, java.util.Comparator.comparing(Car::manufactureYear).reversed());
    println("Comparator.comparing(Car::manufactureYear).reversed:", cars);

    // list sort
    cars.sort(java.util.Comparator.comparing(Car::manufactureYear));
    println(cars);
  }

  @Test
  public void applyCustomComparator() {
    var carSet =
        new TreeSet<Car>(MAX_SPEED_COMPARATOR) {
          {
            add(new Car(2017, "BMV", 300));
            add(new Car(2019, "AUDI", 320));
            add(new Car(2018, "HONDA", 150));
            add(new Car(2024, "MAZDA", 250));
          }
        };

    carSet.forEach(this::println);
  }

  private static final Comparator<Car> MAX_SPEED_COMPARATOR =
      new Comparator<>() {
        @Override
        public int compare(Car o1, Car o2) {
          return o1.maxSpeed() < o2.maxSpeed() ? -1 : 1;
        }
      };

  private record Car(int manufactureYear, String model, int maxSpeed) {}
}
