package com.malex.lecture_14_optional;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import org.junit.Test;

public class OptionalIfPresentVsIfPresentOrElse extends AbstractUtils {

  @Test
  public void ifPresentTest() {
    getText("Text")
        .ifPresent(
            text -> {
              String upperCase = text.toUpperCase();
              print("result:", upperCase);
            });
  }

  @Test
  public void ifPresentOrElseTest() {}

  private Optional<String> getText(String text) {
    return Optional.ofNullable(text);
  }
}
