package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.function.Supplier;
import org.junit.Test;

/**
 * If a value is present, returns an Optional describing the value, otherwise returns an Optional
 * produced by the supplying function. <br>
 * <br>
 * @Contract("null->!null") <br>
 * public Optional<T> or( Supplier<? extends Optional<T>> supplier )
 */
public class OptionalOr extends AbstractUtils {

  @Test
  public void orTest() {
    // given
    var text = "text";

    // when
    var orResult =
        getText(text)
            .or(
                () -> {
                  var defaultVal = "default";
                  println(defaultVal);
                  return Optional.of(defaultVal);
                })
            .orElseThrow();

    // then
    assertEquals(text, orResult);
  }

  /** Return null */
  @Test(expected = NullPointerException.class)
  public void orElsePassNull() {
    // given
    Optional.ofNullable(null) //
        .map(Object::toString)
        .or(null); // Note: NPE
  }

  /** Return empty Optional */
  @Test
  public void orElsePassSupplierEmpty() {
    // given
    Optional<String> or =
        Optional.ofNullable(null) //
            .map(Object::toString)
            .or(
                new Supplier<Optional<? extends String>>() {
                  @Override
                  public Optional<? extends String> get() {
                    return Optional.empty();
                  }
                });

    // then
    assertTrue(or.isEmpty());
  }

  @Test
  public void orMultiNullOrEmptyTest() {
    // given
    var orResult =
        getText(null)
            .or(() -> Optional.ofNullable(null))
            .or(Optional::empty)
            .or(() -> Optional.ofNullable(null))
            .or(Optional::empty)
            .or(() -> Optional.ofNullable(null))
            .or(Optional::empty)
            .or(
                () -> {
                  var defaultVal = "default";
                  println(defaultVal);
                  return Optional.of(defaultVal);
                })
            .orElseThrow();

    // then
    assertEquals("default", orResult);
  }

  @Test
  public void orNullValTest() {
    // given
    var orResult =
        getText(null)
            .or(
                () -> {
                  var defaultVal = "default";
                  println(defaultVal);
                  return Optional.of(defaultVal);
                })
            .orElseThrow();

    // then
    assertEquals("default", orResult);
  }

  private Optional<String> getText(String text) {
    println("getText:", text);
    return Optional.ofNullable(text);
  }
}
