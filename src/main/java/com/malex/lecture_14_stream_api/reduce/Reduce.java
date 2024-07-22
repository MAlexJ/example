package com.malex.lecture_14_stream_api.reduce;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import org.junit.Test;

/**
 * A simple example of using the method 'reduce' of Stream API. Method 'reduce' perform the terminal
 * operation.
 */
public class Reduce {

  @Test
  public void allTests() {
    testReduceWithBinaryOperator();
    testBinaryOperator();
    testIdentityWithBinaryOperator();
    testIdentityWithBiFunctionAndBinaryOperator();
  }

  /**
   * A Simple example of using the method 'reduce' of Stream API. Using: BinaryOperator<T> n1 op n2
   * op n3 op n4 op n5 op n6, where op - is the operation, а n1, n2, ... - elements from Stream.
   */
  private int exampleOfBinaryOperator(int[] array) {
    return Arrays.stream(array).reduce(Integer::sum).orElseThrow(IllegalArgumentException::new);
  }

  /** Example of using concatenation strings in the stream. */
  private String exampleOfBinaryOperatorSecond(String[] array) {
    return Arrays.stream(array)
        .reduce((x, y) -> x + " " + y)
        .orElseThrow(IllegalArgumentException::new);
  }

  /**
   * identity op n1 op n2 op n3 op n4...
   *
   * @param args incoming values
   */
  private String exampleOfIdentityWithBinaryOperator(String... args) {
    return Arrays.stream(args).reduce("RESULT: ", (x, y) -> x + y);
  }

  private int exapmleIdentityWithBiFunctionAndBinaryOperator(Phone... phones) {
    return Arrays.stream(phones)
        .reduce(
            // :1 init state
            0,
            // :2 additional filters
            (x, y) -> {
              if (y.getPrice() < 50000) return x + y.getPrice();
              else return x;
            },
            // :3 operation
            (x, y) -> x + y);
  }

  /** The class describes an entity. */
  @Getter
  @AllArgsConstructor
  @FieldDefaults(level = AccessLevel.PRIVATE)
  private class Phone {
    String name;
    int price;
  }

  @Test
  public void testReduceWithBinaryOperator() {
    // given:
    int[] array = {1, 2, 3, 4, 5};
    int expected = 15;

    // when:
    int actual = exampleOfBinaryOperator(array);

    // then:
    assertEquals(expected, actual);
  }

  @Test
  public void testBinaryOperator() {
    // given:
    String[] array = {"ab", "cd", "efg"};
    String expected = "ab cd efg";

    // when:
    String actual = exampleOfBinaryOperatorSecond(array);

    // then:
    assertEquals(expected, actual);
  }

  @Test
  public void testIdentityWithBinaryOperator() {
    // given:
    String[] array = {"a", "b", "r", "t"};
    String expected = "RESULT: abrt";

    // when:
    String actual = exampleOfIdentityWithBinaryOperator(array);

    // then:
    assertEquals(expected, actual);
  }

  @Test
  public void testIdentityWithBiFunctionAndBinaryOperator() {
    // given:
    Phone[] array = {
      new Phone("iPhone 6 S", 54000),
      new Phone("Lumia 950", 45000),
      new Phone("Samsung Galaxy S 6", 40000),
      new Phone("LG G 4", 32000)
    };
    int expected = 117000;

    // when:
    int actual = exapmleIdentityWithBiFunctionAndBinaryOperator(array);

    // then:
    assertEquals(expected, actual);
  }
}
