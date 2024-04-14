package com.malex.lecture_5_random.samples;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.Random;
import org.junit.Test;

/**
 * Returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified
 * value (exclusive), drawn from this random number generator's sequenc
 */
public class SingleRandomItem extends AbstractUtils {

  private final Random random = new Random();

  /** In order to select a random index, you can use Random.nextInt(int bound) method: */
  @Test
  public void randomNextIntTest() {
    // given
    var list = List.of("first", "second", "third", "x", "oop");

    // then
    for (int i = 0; i < 1000; i++) {
      print(getRandomItem(list), ",");
    }
  }

  private String getRandomItem(List<String> list) {
    // randomIndex -  value between 0 (inclusive) and the specified value (exclusive)
    int randomIndex = random.nextInt(list.size());
    return list.get(randomIndex);
  }
}
