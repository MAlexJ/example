package com.malex.lecture_5_String.tokenizer;

import static org.junit.Assert.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import org.junit.Test;

/** Example parse string with multiple delimiters of using StringTokenizer */
public class StringTokenizerExample extends AbstractUtils {

  @Test
  public void sampleWithOneDelimiter() {
    wrapper(
        "Parse string line with one ':' delimiter",
        () -> {
          // given
          String message = "1:23:4:546:21:0:3";
          StringTokenizer tokenizer = new StringTokenizer(message, ":");

          // when
          Integer[] numbers = new Integer[tokenizer.countTokens()];
          for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.valueOf(tokenizer.nextToken());
          }

          // then
          print(Arrays.toString(numbers));
          assertEquals(numbers[0], Integer.valueOf(1));
          assertEquals(numbers[numbers.length - 1], Integer.valueOf(3));
        });
  }

  @Test
  public void sampleWithThreeDelimiter() {
    wrapper(
        "Parse string line with multiple ':,?' delimiters",
        () -> {
          // given
          String str = "Mxx:23:4?546:21?XXX:3";
          StringTokenizer tokenizer = new StringTokenizer(str, ":,?");

          // when
          String[] words =
              IntStream.range(0, tokenizer.countTokens())
                  .mapToObj(num -> tokenizer.nextToken())
                  .toArray(String[]::new);

          // then
          print(Arrays.toString(words));
          assertEquals(words[0], "Mxx");
          assertEquals(words[6], "3");
        });
  }
}
