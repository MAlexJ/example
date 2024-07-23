package com.malex.lecture_14_stream_api.filter;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;

/**
 * @author malex
 */
public class Filter extends AbstractUtils {

  private static final List<String> LIST =
      List.of("Paris", "London", "Madrid", "Berlin", "Brussels");

  @Test
  public void test() {
    Predicate<String> predicate = city -> city.length() > 6;

    var cities = LIST.stream().filter(predicate).toList();

    println("Cities: " + cities);
  }
}
