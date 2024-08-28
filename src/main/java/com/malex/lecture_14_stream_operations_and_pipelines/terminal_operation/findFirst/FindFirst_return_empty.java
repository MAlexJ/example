package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.findFirst;

import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * Returns: empty Optional if the stream is empty
 */
public class FindFirst_return_empty extends AbstractUtils {

  @Test
  public void empty() {
    Optional<Object> first = Stream.of().findFirst();
    assertTrue(first.isEmpty());
    println("first:", first);
  }
}
