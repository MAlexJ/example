package com.malex.lecture_13_generic.extends_super;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class Gen<T extends Number> {

  private static final double DEFAULT_VALUE = 0.0;
  private T[] array;

  private double average() {
    return Arrays.stream(array).mapToDouble(Number::doubleValue).average().orElse(DEFAULT_VALUE);
  }

  boolean sameAvg(Gen<? extends Number> ob) {
    return average() == ob.average();
  }

  boolean sameAvgShort(Gen<? super Short> ob) {
    return average() == ob.average();
  }
}
