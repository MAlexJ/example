package com.malex.lecture_14_optional;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import org.junit.Test;

public class OptionalIsPresentVsIsEmpty extends AbstractUtils {

  @Test
  public void optionalNotEmptyTest() {
    // given
    Optional<String> textOpt = getText("123_adc");

    // when
    boolean present = textOpt.isPresent();
    boolean empty = textOpt.isEmpty();

    // then
    assertTrue(present);
    assertFalse(empty);
    // and
    println("result:", textOpt);
  }

  @Test
  public void optionalEmptyTest() {
    // given
    Optional<String> textOpt = getText(null);

    // when
    boolean empty = textOpt.isEmpty();
    boolean present = textOpt.isPresent();

    // then
    assertTrue(empty);
    assertFalse(present);
    // and
    println("result:", textOpt);
  }

  private Optional<String> getText(String text) {
    return Optional.ofNullable(text);
  }
}
