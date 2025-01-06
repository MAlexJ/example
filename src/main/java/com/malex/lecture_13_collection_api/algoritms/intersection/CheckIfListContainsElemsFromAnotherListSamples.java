package com.malex.lecture_13_collection_api.algoritms.intersection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.List;
import org.junit.Test;

public class CheckIfListContainsElemsFromAnotherListSamples extends AbstractUtils {

  @Test
  public void testListIntersection() {
    // given
    var first = List.of("X", "S", "X", "C", "C", "D");
    var second = List.of("C", "X", "E", "E", "J", "D");
    println("first:", first);
    println("second:", second);

    // and
    var expected = List.of("C", "D", "X");

    // when
    List<String> commonCharacters = ListIntersection.intersection(first, second);
    println("common:", commonCharacters);

    // then
    assertTrue(ListIntersection.hasIntersection(first, second));

    // and
    assertEquals(expected.size(), commonCharacters.size());
    assertTrue(expected.containsAll(commonCharacters));
  }

  @Test
  public void testSetIntersection() {
    // given
    List<String> first = List.of("R", "S", "B", "C", "C", "D");
    List<String> second = List.of("C", "D", "E", "E");
    println("first:", first);
    println("second:", second);

    // and
    List<String> expected = List.of("C", "D");

    // when
    List<String> commonCharacters = SetIntersection.intersection(first, second);
    println("common:", commonCharacters);

    // note: It will work and if orders of elements are respected
    assertEquals(expected, commonCharacters);

    // and
    assertEquals(expected.size(), commonCharacters.size());
    assertTrue(expected.containsAll(commonCharacters));
  }
}
