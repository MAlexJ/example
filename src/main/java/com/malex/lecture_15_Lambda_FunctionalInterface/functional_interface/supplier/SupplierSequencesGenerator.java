package com.malex.lecture_15_Lambda_FunctionalInterface.functional_interface.supplier;

import static junit.framework.TestCase.assertEquals;

import java.util.NoSuchElementException;
import java.util.function.Supplier;
import org.junit.Test;

public class SupplierSequencesGenerator {

  @Test(expected = NoSuchElementException.class)
  public void testGenerator() {
    // given
    var generatorSupplier = new SequenceGenerator(0, 4, 2);
    // then
    assertEquals(Integer.valueOf(0), generatorSupplier.get());
    assertEquals(Integer.valueOf(2), generatorSupplier.get());
    assertEquals(Integer.valueOf(4), generatorSupplier.get());
    generatorSupplier.get();
  }

  @Test
  public void testInfinityGenerator() {
    // given
    int start = -20;
    int step = 2;
    // then
    var infinitySupplier = new SequenceGenerator(start, step);
    for (int i = start; i <= 20; i = i + step) {
      assertEquals(Integer.valueOf(i), infinitySupplier.get());
    }
  }

  private final class SequenceGenerator implements Supplier<Integer> {
    private final Integer end;
    private final Integer step;
    private Integer start;

    private SequenceGenerator(Integer start, Integer end, Integer step) {
      this.start = start;
      this.end = end;
      this.step = step;
    }

    private SequenceGenerator(int start, int step) {
      this.start = start;
      this.step = step;
      this.end = 0;
    }

    @Override
    public Integer get() {
      if (start > end && end != 0) {
        throw new NoSuchElementException();
      }
      this.start += step;
      return (start - step);
    }
  }
}
