package com.malex.lecture_3_wrapper_classes;

import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.lang.constant.Constable;
import org.junit.Test;

public class PrimitiveWrapperClasses extends AbstractUtils {

  @Test
  public void wrappers() {

    /* 8x primitive type*/
    byte numbByte = 10;
    short numShort = 15;
    int nubInt = 20;
    long numLong = 25L;
    float numFloat = 12.0f;
    double numDouble = 12.00;
    char literalChar = 's';
    boolean flag = true;

    /* Class Wrapper*/
    Byte b = numbByte;
    Short s = numShort;
    Integer i = nubInt;
    Long l = numLong;
    Float f = numFloat;
    Double d = numDouble;
    Character c = literalChar;
    Boolean boo = flag;

    assertTrue(b instanceof Number);
    assertTrue(s instanceof Number);
    assertTrue(i instanceof Number);
    assertTrue(l instanceof Number);
    assertTrue(f instanceof Number);
    assertTrue(d instanceof Number);
    assertTrue(c instanceof Character);

    assertTrue(c instanceof Constable);
    assertTrue(boo instanceof Constable);

    // auto boxing ->  i.intValue() & auto unboxing.
    int number = i + nubInt;
    print(number);
  }
}
