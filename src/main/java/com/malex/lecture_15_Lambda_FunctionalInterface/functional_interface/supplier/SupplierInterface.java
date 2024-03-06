package com.malex.lecture_15_Lambda_FunctionalInterface.functional_interface.supplier;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.UUID;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import org.junit.Test;

/**
 * Tutorial: <a
 * href="https://www.youtube.com/watch?v=cl12wAVFPrU&list=PLtNPgSbW9TX5IQAKzgrJnaayjaDoCjkio">Supplier</a>
 */
public class SupplierInterface extends AbstractUtils {

  private final Random random = new Random();

  /**
   * Case 1: <br>
   * lambda interface
   */
  @Test
  public void lambdaInterface() {
    // test 1
    IntSupplier randomSupplier = () -> random.nextInt(100);
    print("random int -", randomSupplier.getAsInt());

    // test 2
    var uuid = UUID.randomUUID();
    Supplier<UUID> randomUuidSupplier = () -> uuid;
    assertEquals(uuid, randomUuidSupplier.get());
  }

  /**
   * Case 2: <br>
   * Method reference
   */
  @Test
  public void methodReference() {
    IntSupplier randomSupplier = this::getRandomMethod;
    print("random int -", randomSupplier.getAsInt());
  }

  private Integer getRandomMethod() {
    return random.nextInt(10);
  }

  /**
   * Case 3:<br>
   * Implementation of Supplier interface
   */
  @Test(expected = NoSuchElementException.class)
  public void sequenceGenerator() {
    // given
    var generatorSupplier = new SequencesGeneratorSupplier(0, 8, 2);
    // then
    assertEquals(Integer.valueOf(0), generatorSupplier.get());
    // and
    assertEquals(Integer.valueOf(2), generatorSupplier.get());
    // and
    assertEquals(Integer.valueOf(4), generatorSupplier.get());
    // and
    assertEquals(Integer.valueOf(6), generatorSupplier.get());
    // and
    assertEquals(Integer.valueOf(8), generatorSupplier.get());
    // and
    generatorSupplier.get();
  }

  @Test(expected = NoSuchElementException.class)
  public void sequenceGeneratorAdditional() {
    // given
    var generator = new SequencesGeneratorSupplier(2, 6, 4);
    // then
    assertEquals(Integer.valueOf(2), generator.get());
    // and
    assertEquals(Integer.valueOf(6), generator.get());
    // and
    generator.get();
  }

  @Test(expected = NoSuchElementException.class)
  public void sequenceGeneratorOne() {
    // given
    var generator = new SequencesGeneratorSupplier(2, 4, 4);
    // then
    assertEquals(Integer.valueOf(2), generator.get());
    // and
    generator.get();
  }

  private static final class SequencesGeneratorSupplier implements Supplier<Integer> {

    private final int step;
    private final int end;

    private int cursor;

    boolean isProcessingStarted = true;

    SequencesGeneratorSupplier(int start, int end, int step) {
      this.cursor = start;
      this.end = end;
      this.step = step;
    }

    @Override
    public Integer get() {
      if (isProcessingStarted) {
        isProcessingStarted = false;
        return cursor;
      }
      cursor = cursor + step;
      if (cursor > end) throw new NoSuchElementException();
      return cursor;
    }
  }
}
