package com.malex.lecture_13_generic.extends_class_and_interface;

import static junit.framework.TestCase.assertEquals;

import com.malex.lecture_13_generic.extends_class_and_interface.model.GenericType;
import com.malex.lecture_13_generic.extends_class_and_interface.model.base.MyClass;
import com.malex.lecture_13_generic.extends_class_and_interface.model.base.MyInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.java.Log;

@Log
public class AppRun {
  private static final String STRING_FORMAT = "The average [%s] value = [%s]";

  public static void main(String[] args) {
    GenericType<Int32> genericTypeInt32 =
        new GenericType<>(new Int32[] {new Int32(1), new Int32(2), new Int32(3)});
    double averageInt32 = genericTypeInt32.average();
    log.info(String.format(STRING_FORMAT, "averageInt32", averageInt32));

    GenericType<Double32> genericTypeDouble32 =
        new GenericType<>(new Double32[] {new Double32(1.0), new Double32(2.0), new Double32(3.0)});
    double averageDouble32 = genericTypeDouble32.average();
    log.info(String.format(STRING_FORMAT, "averageDouble32", averageDouble32));

    assertEquals(averageInt32, averageDouble32);
  }

  @Getter
  @AllArgsConstructor
  private static class Int32 extends MyClass implements MyInterface {
    private int num;

    @Override
    public double doubleValue() {
      return num;
    }
  }

  @Getter
  @AllArgsConstructor
  private static class Double32 extends MyClass implements MyInterface {
    private double num;

    @Override
    public double doubleValue() {
      return num;
    }
  }
}
