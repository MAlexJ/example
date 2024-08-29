package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.toList;

import com.malex.utils.AbstractUtils;
import java.util.List;
import org.junit.Test;

/*
 * Accumulates the elements of this stream into a List.
 * The elements in the list will be in this stream's encounter order, if one exists.
 * The returned List is unmodifiable
 */
public class ToList_method extends AbstractUtils {

  /*
   * The returned List is unmodifiable
   */
  @Test
  public void toList() {
    var unmodifiableList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream().toList();
    println("unmodifiableList:", unmodifiableList);
  }
}
