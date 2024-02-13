package com.malex.lecture_14_stream_api.example_12_get_last_element_in_stream;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

/**
 * Tutorial: How to Get the Last Element of a Stream in Java
 *
 * <p>Link: <a href="https://www.baeldung.com/java-stream-last-element">Last Element of a Stream in
 * Java</a>
 */
public class GetLastElementInStream extends AbstractUtils {

  private List<String> list;

  private final Random random = new Random();

  @Before
  public void before() {
    list =
        List.of(
            randomAlphabeticString(5),
            randomAlphabeticString(6),
            randomAlphabeticString(7),
            randomAlphabeticString(4),
            randomAlphabeticString(7),
            randomAlphabeticString(10),
            randomAlphabeticString(3),
            "test");
  }

  /** Using the Reduce API */
  @Test
  public void findLastElementUsingReduce() {
    // find last element
    String lastElement = list.stream().reduce((first, second) -> second).orElseThrow();
    assertEquals(list.getLast(), lastElement);
    assertEquals(list.getLast(), "test");

    // java 21
    print("Since java 21: first -", list.getFirst(), ", last - ", list.getLast());

    // first element with reduce
    String firstElement = list.stream().reduce((first, second) -> first).orElseThrow();
    assertEquals(list.getFirst(), firstElement);
  }

  @Test
  public void findLastElementUsingSkipFunction() {
    int size = list.size();
    String lastElement = list.stream().skip(size - 1).findFirst().orElseThrow();

    println("last element:", lastElement);
    assertEquals(list.getLast(), lastElement);
  }

  /**
   * Generate Random Alphabetic String With Java 8 <br>
   * Now let’s use Random.ints, added in JDK 8, to generate an alphabetic String
   */
  public String randomAlphabeticString(int length) {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    return random
        .ints(leftLimit, rightLimit - 1)
        .limit(length)
        .mapToObj(Character::toString)
        .collect(Collectors.joining());
  }
}
