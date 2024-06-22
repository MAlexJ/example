package com.malex.lecture_4_algorithms.strings.find_index_or_element;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/** */
public class FindHighestValueInArray extends AbstractUtils {

  @Test
  public void secondSolution() {
    // given
    int max = 1234;
    // and
    int[] array = generateRandomArray(max);

    // when
    var highestValue =
        Arrays.stream(array) //
            .boxed() //
            .max(Comparator.naturalOrder()) //
            .orElseThrow();
    println(highestValue);

    // than
    assertEquals(max, highestValue.intValue());
  }

  private int[] generateRandomArray(int highestValue) {
    List<Integer> integerList = IntStream.range(-1000, 1000).boxed().collect(Collectors.toList());
    integerList.add(highestValue);
    Collections.shuffle(integerList);
    return integerList.stream() //
        .mapToInt(Integer::intValue) //
        .toArray();
  }
}
