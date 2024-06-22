package com.malex.lecture_4_algorithms.strings.find_index_or_element;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * Find the Index of the Largest Value in an Array, link:
 * https://www.baeldung.com/java-array-find-index-maximum <br>
 * <br>
 * <li>1. Converting the Array to a List
 * <li>2. Looping Through the Array
 * <li>3. Using the Stream API
 */
public class FindIndexOfLargestValueInArray extends AbstractUtils {

  /** 1. Apply indexOf method in ArrayList */
  @Test
  public void applyIndexOfInArrayList() {
    // given
    int highestValue = 734976;
    // and
    int[] array = Utils.generateRandomArray(highestValue);

    // when
    var list = Arrays.stream(array).boxed().toList();
    var max = Collections.max(list);
    int indexOf = list.indexOf(max);

    // then
    assertEquals(Utils.findIndexInArray(array, highestValue), indexOf);
  }

  /**
   * 2. Looping Through the Array
   *
   * <p>We can traverse the array to find the index of the largest element.
   */
  @Test
  public void loopingThroughArray() {
    // given
    int highestValue = 456789;
    // and
    int[] array = Utils.generateRandomArray(highestValue);

    // when
    int indexOf = 0;
    for (int i = 0; i < array.length; i++) {
      indexOf = (array[i] > array[indexOf]) ? i : indexOf;
    }

    // then
    assertEquals(Utils.findIndexInArray(array, highestValue), indexOf);
  }

  /** 3. Using the Stream API */
  @Test
  public void usingStreamApi() {
    // given
    int highestValue = 456789;
    // and
    int[] array = Utils.generateRandomArray(highestValue);

    // when
    int indexOf =
        IntStream.range(0, array.length)
            .boxed() //
            .max(Comparator.comparing(i -> array[i])) //
            .orElseThrow(() -> new IllegalArgumentException("Cannot find element " + highestValue));

    // then
    assertEquals(Utils.findIndexInArray(array, highestValue), indexOf);
  }

  /** Utils class */
  private static class Utils {

    private static final Random random = new Random();

    private static int[] generateRandomArray(int highestValue) {
      // 1. generate random list
      var integerList =
          IntStream.range(-892, 896)
              .boxed()
              .filter(num -> random.nextBoolean())
              .collect(Collectors.toList());

      // 2. add highest value
      integerList.add(highestValue);

      // 3. Randomly permutes the specified list
      Collections.shuffle(integerList);

      // 4. convert list to array
      return integerList.stream() //
          .mapToInt(Integer::intValue) //
          .toArray();
    }

    /* Todo: Find index of the search key, if it is contained in the array; otherwise -1 */

    //    private int findIndexInArray(int[] array, int element) {
    //      int[] innerArray = Arrays.copyOf(array, array.length);
    //
    //      println("Find index in array");
    //      /*
    //      Note: Arrays.binarySearch(array, element) ??? WTF!!!
    //
    //      Searches the specified array of ints for the specified value using the binary search
    // algorithm.
    //      The array must be sorted (as by the sort(int[]) method) prior to making this call.
    //      If it is not sorted, the results are undefined.
    //       */
    //      Arrays.sort(innerArray);
    //      int binarySearch = Arrays.binarySearch(innerArray, element);
    //      return Optional.of(binarySearch)
    //          .filter(index -> index >= 0)
    //          .orElseThrow(() -> new IllegalArgumentException("Cannot find element " + element));
    //    }

    /** Find index of the search key, if it is contained in the array; otherwise -1 */
    private static int findIndexInArray(int[] array, int element) {
      for (int i = 0; i < array.length; i++) {
        if (array[i] == element) {
          return i;
        }
      }
      throw new IllegalArgumentException("Cannot find element " + element);
    }
  }

  @Test
  public void testUtilsMethods() {
    // given
    int highestValue = new Random().nextInt(7486509);
    printlnString("Highest Value: " + highestValue);

    // and
    int[] array = Utils.generateRandomArray(highestValue);

    // when
    int indexOfHighestValue = Utils.findIndexInArray(array, highestValue);

    // then
    assertEquals(highestValue, array[indexOfHighestValue]);
  }
}
