package com.malex.lecture_13_generic.extends_class_and_interface.model;

import com.malex.lecture_13_generic.extends_class_and_interface.model.base.MyClass;
import com.malex.lecture_13_generic.extends_class_and_interface.model.base.MyInterface;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GenericType<T extends MyClass & MyInterface> {

  private static final double DEFAULT_VALUE = 0.0;
  private T[] array;

  public double average() {
    return Arrays.stream(array).mapToDouble(MyClass::doubleValue).average().orElse(DEFAULT_VALUE);
  }

  public double averageOldStyle() {
    double sum = DEFAULT_VALUE;
    for (T num : array) {
      sum += num.doubleValue();
    }
    return sum / array.length;
  }
}
