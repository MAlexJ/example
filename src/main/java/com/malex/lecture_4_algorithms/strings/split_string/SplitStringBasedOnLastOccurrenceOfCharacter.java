package com.malex.lecture_4_algorithms.strings.split_string;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

/**
 * Split a String Based on the Last Occurrence of a Character
 *
 * <p>link: https://www.baeldung.com/java-string-split-last-occurrence
 */
public class SplitStringBasedOnLastOccurrenceOfCharacter extends AbstractUtils {

  @Test
  public void splitString() {
    // given
    var character = "@";

    assertEquals("x y z", lastOccurrenceOfCharacter("a b c@e f g@x y z", character));
    assertEquals("", lastOccurrenceOfCharacter("a b c@e f g x y z@", character));
    assertEquals("a b c e f g x y z", lastOccurrenceOfCharacter("@a b c e f g x y z", character));
  }

  private String lastOccurrenceOfCharacter(String input, String character) {
    int lastIndex = input.lastIndexOf(character);
    if (lastIndex < 0) {
      return input;
    }
    return input.substring(lastIndex + 1);
  }
}
