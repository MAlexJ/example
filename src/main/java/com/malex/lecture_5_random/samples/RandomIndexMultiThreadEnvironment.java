package com.malex.lecture_5_random.samples;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;

/** Select Random Index in MultiThread Environment */
public class RandomIndexMultiThreadEnvironment extends AbstractUtils {

  @Test
  public void threadLocalRandomTest() {
    // given
    var list = List.of("first", "second", "third", "x", "oop");

    // then
    for (int i = 0; i < 1000; i++) {
      print(getRandomItem(list), ",");
    }
  }

  private String getRandomItem(List<String> list) {
    int randomElementIndex = ThreadLocalRandom.current().nextInt(list.size()) % list.size();
    return list.get(randomElementIndex);
  }
}
