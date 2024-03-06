package com.malex.lecture_15_Lambda_FunctionalInterface.functional_interface.consumer.binary_functions;

import com.malex.utils.AbstractUtils;
import java.util.Map;
import java.util.function.BiConsumer;
import org.junit.Test;

public class BiConsumerMapForeach extends AbstractUtils {

  @Test
  public void simple() {
    var map = Map.of(1, "one", 2, "two", 3, "three");
    BiConsumer<Integer, String> biConsumer = (num, str) -> println((str + " ").repeat(num));
    map.forEach(biConsumer);
  }
}
