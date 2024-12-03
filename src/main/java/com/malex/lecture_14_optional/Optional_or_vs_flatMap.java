package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import org.junit.Test;

public class Optional_or_vs_flatMap extends AbstractUtils {

  @Test
  public void or_test() {
    // given
    String val = null;

    // when
    Optional<String> valOpt =
        Optional.ofNullable(val)
            .or(
                () -> {
                  println("1. flatMap");
                  return Optional.of("Value".toUpperCase());
                });

    println("Result:", valOpt);
    assertTrue(valOpt.isPresent());
  }

  @Test
  public void flatMap_test() {
    // given
    String val = null;

    // when
    Optional<String> valOpt =
        Optional.ofNullable(val)
            .flatMap(
                v -> {
                  println("1. flatMap");
                  return Optional.of(v.toUpperCase());
                })
            .flatMap(v -> Optional.of(v.replaceAll("[^A-Z]", "*")));
    println("Result:", valOpt);

    // then
    assertTrue(valOpt.isEmpty());
  }
}
