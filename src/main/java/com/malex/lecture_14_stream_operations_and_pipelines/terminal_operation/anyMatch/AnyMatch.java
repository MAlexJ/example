package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.anyMatch;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * Returns whether any elements of this stream match the provided predicate. May not evaluate the
 * predicate on all elements if not necessary for determining the result. If the stream is empty
 * then false is returned and the predicate is not evaluated. This is a short-circuiting terminal
 * operation. Params: predicate – a non-interfering, stateless predicate to apply to elements of
 * this stream Returns: true if any elements of the stream match the provided predicate, otherwise
 * false
 */
public class AnyMatch extends AbstractUtils {

  @Test
  public void emptyList() {
    // given
    var emptyList = Collections.emptyList();
    // and
    var list = List.of("XxX", "A", "B");

    // when
    boolean anyMatch =
        emptyList.stream() //
            .peek(el -> println("el:", el))
            .anyMatch(list::contains);

    // then
    assertFalse(anyMatch);
  }

  @Test
  public void elementNotFoundInList() {
    // given
    var emptyList = List.of("A", "B", "C", "D");
    // and
    var list = List.of("Z", "X");

    // when
    boolean anyMatch =
        emptyList.stream() //
            .peek(el -> println("el:", el))
            .anyMatch(list::contains);

    // then
    assertFalse(anyMatch);
  }

  @Test
  public void onlyOneFound() {
    // given
    var emptyList = List.of("A", "B", "C", "D", "E", "X");
    // and
    var list = List.of("C", "X");

    // when
    boolean anyMatch =
        emptyList.stream() //
            .peek(el -> println("el:", el))
            .anyMatch(list::contains);

    // then
    assertTrue(anyMatch);
  }

  @Test
  public void anyMatchForList() {
    var list = Arrays.asList("A", "B", "C", "D", "E");

    // contains
    assertTrue(list.stream().anyMatch(el -> el.contains("A")));
    assertTrue(list.stream().anyMatch(el -> el.contains("B")));
    assertTrue(list.stream().anyMatch(el -> el.contains("C")));

    // not contains
    assertFalse(list.stream().anyMatch(el -> el.contains("XXX")));
  }
}
