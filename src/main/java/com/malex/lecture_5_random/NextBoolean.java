package com.malex.lecture_5_random;

import com.malex.utils.AbstractUtils;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.Test;

public class NextBoolean extends AbstractUtils {

  @Test
  public void nextBooleanMethod() {
    var random = new Random();
    IntStream.range(0, 20)
        .forEach(
            i -> {
              println(random.nextBoolean());
            });
  }
}
