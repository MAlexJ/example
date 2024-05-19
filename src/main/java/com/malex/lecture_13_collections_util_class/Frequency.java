package com.malex.lecture_13_collections_util_class;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

/**
 * Returns the number of elements in the specified collection equal to the specified object. More
 * formally, returns the number of elements e in the collection such that Objects. equals(o, e).
 */
public class Frequency extends AbstractUtils {

  @Test
  public void frequency() {
    // given
    String word = "or";
    String string = "the colored port should be black or white or brown or";

    // when
    int count = Collections.frequency(Arrays.asList(string.split(" ")), word);

    // then
    assertEquals(3, count);
  }
}
