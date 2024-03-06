package com.malex.lecture_15_Lambda_FunctionalInterface.functional_interface.consumer;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.junit.Test;

/**
 * In Java, a side effect is anything a method does besides computing and returning a value. <br>
 * This can include:
 *
 * <ul>
 *   <li>Changing the value of instance or class fields
 *   <li>Drawing something on the screen
 *   <li>Writing to a file or a network connection
 *   <li>Modifying a data structure
 *   <li>Running IO
 * </ul>
 */
public class ConsumerSideEffect extends AbstractUtils {

  @Test
  public void runSideEffect() {
    // given
    var result = new ArrayList<>();
    Consumer<String> consumer =
        phrase -> {
          if (phrase.startsWith("J")) {
            result.add(phrase);
          }
        };

    // when
    consumer.accept("Java");
    consumer.accept("Python");
    consumer.accept("JavaScript");

    // then
    assertEquals(List.of("Java", "JavaScript"), result);
  }
}
