package com.malex.lecture_14_optional;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import org.junit.Test;

public class Optional_or_map_orElse extends AbstractUtils {

  // action: only 2 section
  @Test
  public void or_Map_OrElse() {
    String val = "Input";
    var result =
        Optional.ofNullable(val)
            .or(
                () -> {
                  println("1. Section: or");
                  return Optional.of("New value");
                })
            .map(
                str -> {
                  println("2. Section: map");
                  return str.toUpperCase();
                })
            .orElseGet(
                () -> {
                  println("3. Section: orElseGet");
                  return "orElseGet";
                });
    println("Result: ", result);
  }

  // action: section: 1 -> section: 2
  @Test
  public void or_Map_OrElse_Null() {
    String val = null;
    String result =
        Optional.ofNullable(val)
            .or(
                () -> {
                  println("1. Section: or");
                  return Optional.of("New value");
                })
            .map(
                str -> {
                  println("2. Section: map");
                  return str.toUpperCase();
                })
            .orElseGet(
                () -> {
                  println("3. Section: orElseGet");
                  return "orElseGet";
                });
    println("Result: ", result);
  }
}
