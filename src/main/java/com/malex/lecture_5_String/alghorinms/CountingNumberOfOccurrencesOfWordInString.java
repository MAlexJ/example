package com.malex.lecture_5_String.alghorinms;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.Test;

/** counting number of occurrences of a word in a string using Java */
public class CountingNumberOfOccurrencesOfWordInString extends AbstractUtils {

  @Test
  public void test() {
    // given
    String text = "the colored port port should be black or white or brown or";

    // when
    Map<String, Integer> occurrences = findOccurrences(text);
    println(occurrences);

    // then
    assertEquals(occurrences.get("or"), Integer.valueOf(3));
    assertEquals(occurrences.get("port"), Integer.valueOf(2));
    assertEquals(occurrences.get("white"), Integer.valueOf(1));
  }

  private Map<String, Integer> findOccurrences(String text) {
    List<String> words = extractAllWordsFromText(text);
    return uniqueWords(words).stream()
        .map(word -> new Pair(word, find(words, word)))
        .collect(Collectors.toMap(Pair::word, Pair::count));
  }

  private Set<String> uniqueWords(List<String> words) {
    return new HashSet<>(words);
  }

  private List<String> extractAllWordsFromText(String text) {
    return Arrays.stream(text.split(" ")).toList();
  }

  private int find(List<String> words, String word) {
    return Collections.frequency(words, word);
  }

  private record Pair(String word, Integer count) {}
}
