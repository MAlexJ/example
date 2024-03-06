package com.malex.lecture_15_Lambda.consumer;

import com.malex.utils.AbstractUtils;
import java.util.function.Consumer;
import org.junit.Test;

public class ConsumerAndThen extends AbstractUtils {

  @Test
  public void andThen() {
    // given
    Consumer<String> first = str -> print("<", str);
    Consumer<String> second = str -> println(">");

    // when
    Consumer<String> result = first.andThen(second);

    // then
    result.accept("Hello!"); // < Hello!>
  }
}
