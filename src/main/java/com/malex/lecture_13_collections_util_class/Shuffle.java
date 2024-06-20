package com.malex.lecture_13_collections_util_class;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import org.junit.Test;

/**
 * Randomly permutes the specified list using a default source of randomness. <br>
 * All permutations occur with approximately equal likelihood.
 *
 * <p>public static void shuffle( @NotNull List<?> list )
 */
public class Shuffle extends AbstractUtils {

  private static final List<String> LIST_OF =
      List.of("apple", "banana", "cherry", "date", "elderberry");

  /**
   * Shuffle the list randomly
   *
   * <p>Randomly permutes the specified list using a default source of randomness. All permutations
   * occur with approximately equal likelihood.
   */
  @Test
  public void shuffle() {
    // given
    var list = new ArrayList<>(LIST_OF);
    println("Original list: " + list);

    // when
    for (int i = 0; i < 10; i++) {
      Collections.shuffle(list);
      println("Shuffled list: " + list);
    }

    // then
    assertEquals(LIST_OF.size(), list.size());
  }

  @Test
  public void shuffleWithRandom() {
    // given
    var list = new ArrayList<>(LIST_OF);
    println("Original list: " + list);

    // when
    for (int i = 0; i < 10; i++) {
      Collections.shuffle(list, Random.from(RandomGenerator.getDefault()));
      println("Shuffled list: " + list);
    }

    // then
    assertEquals(LIST_OF.size(), list.size());
  }
}
