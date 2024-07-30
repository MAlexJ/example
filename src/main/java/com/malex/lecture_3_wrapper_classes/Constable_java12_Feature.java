package com.malex.lecture_3_wrapper_classes;

import com.malex.utils.AbstractUtils;
import java.lang.constant.Constable;
import org.junit.Test;

/*
 * Represents a type which is constable.
 *
 * A constable type is one whose values are constants that can be represented in the constant pool
 * of a Java classfile as described in JVMS @jvms 4.4, and whose instances can describe themselves nominally
 * as a ConstantDesc.
 *
 * Some constable types have a native representation in the constant pool:
 *   String, Integer, Long, Float, Double, Class, MethodType, and MethodHandle.
 *
 * The types String, Integer, Long, Float, and Double serve as their own nominal descriptors;
 * Class, MethodType, and MethodHandle have corresponding nominal descriptors ClassDesc, MethodTypeDesc,
 * and MethodHandleDesc.
 */
public class Constable_java12_Feature extends AbstractUtils {

  @Test
  public void test() {
    Constable constableValue = Boolean.TRUE;
    print(constableValue);

    constableValue = Integer.parseInt("1");
    print(constableValue);

    constableValue = Character.valueOf((char) 12);
    print(constableValue);
  }
}
