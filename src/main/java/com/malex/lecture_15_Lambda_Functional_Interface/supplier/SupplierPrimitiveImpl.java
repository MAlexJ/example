package com.malex.lecture_15_Lambda_Functional_Interface.supplier;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import org.junit.Test;

/**
 * Primitive implementation of Supplier: <br>
 * <br>
 * 1. BooleanSupplier.getAsBoolean() <br>
 * 2. IntSupplier.getAsInt(); <br>
 * 3. LongSupplier.getAsLong() <br>
 * 4. DoubleSupplier.getAsDouble() <br>
 */
public class SupplierPrimitiveImpl {

  @Test
  public void sample() {
    BooleanSupplier booleanSupplier = () -> true;
    booleanSupplier.getAsBoolean();

    IntSupplier intSupplier = () -> 12;
    intSupplier.getAsInt();

    LongSupplier longSupplier = () -> 15L;
    longSupplier.getAsLong();

    DoubleSupplier doubleSupplier = () -> 1.5d;
    doubleSupplier.getAsDouble();
  }
}
