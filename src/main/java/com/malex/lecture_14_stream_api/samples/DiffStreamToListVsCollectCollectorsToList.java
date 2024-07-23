package com.malex.lecture_14_stream_api.samples;

import com.malex.utils.AbstractUtils;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class DiffStreamToListVsCollectCollectorsToList extends AbstractUtils {

  /**
   * The returned List is unmodifiable; calls to any mutator method will always cause
   * UnsupportedOperationException to be thrown.
   */
  @Test(expected = UnsupportedOperationException.class)
  public void testStreamToList() {
    List<Integer> list = Stream.of(1, 2, 3, 4, 5).toList();
    list.remove(0);
  }

  /**
   * There are no guarantees on the type, mutability, serializability, or thread-safety of the List
   * returned
   */
  @Test
  public void testStreamCollectCollectorsToList() {
    List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
    list.add(0);
    list.remove(Integer.valueOf(5));
    println("List: ", list);
  }
}
