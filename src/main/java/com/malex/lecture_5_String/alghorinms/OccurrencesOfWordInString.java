package com.malex.lecture_5_String.alghorinms;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import com.malex.utils.AbstractUtils;
import com.malex.utils.SampleException;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Occurrences of a word in a string
 *
 * <p>link: <a
 * href="https://www.linkedin.com/learning/java-practice-collections/solution-occurrences-of-a-word-in-a-string?resume=false">...</a>
 */
public class OccurrencesOfWordInString extends AbstractUtils {

  private static final String EMPTY_STRING = " ";

  private final List<String> texts =
      List.of(
          "In this tutorial, we presented a \n \n case-insensitive search algorithm",
          "In this case, we can safely avoid doing the backup to re-check every location in the text string",
          "If we know in advance that the search word does not contain a repetitive pattern of characters");

  @Test
  public void run() {
    assertTrue(findOccurrence(texts.getFirst(), "tutorial"));
    assertFalse(findOccurrence(texts.getFirst(), "tutorials"));
    assertFalse(findOccurrence(texts.getFirst(), "tutor"));

    assertTrue(findOccurrence(texts.getFirst(), "case"));
    assertTrue(findOccurrence(texts.getFirst(), "insensitive"));

    assertFalse(findOccurrence(texts.getFirst(), "case-insensitive"));
    assertFalse(findOccurrence(texts.getFirst(), "sensitive"));
  }

  private boolean findOccurrence(String text, String word) {
    if (text == null || word == null) {
      throw new SampleException("Text or word should be not null!");
    }
    String excludePunctuationMarksWormText = text.replaceAll("[\\p{P}\\s]", EMPTY_STRING);
    String[] wordList = excludePunctuationMarksWormText.split(EMPTY_STRING);
    println(Arrays.toString(wordList));
    return Arrays.stream(wordList) //
        .filter(s -> !s.isBlank())
        .anyMatch(w -> w.equalsIgnoreCase(word));
  }
}
