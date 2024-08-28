package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.all_any_none_match.allMatch;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.*;
import org.junit.Test;

/**
 * Returns whether all elements of this stream match the provided predicate. May not evaluate the
 * predicate on all elements if not necessary for determining the result. If the stream is empty
 * then true is returned and the predicate is not evaluated. This is a short-circuiting terminal
 * operation. Params: predicate – a non-interfering, stateless predicate to apply to elements of
 * this stream Returns: true if either all elements of the stream match the provided predicate or
 * the stream is empty, otherwise false
 */
public class AllMatch extends AbstractUtils {

  /** NOTE: If the stream is empty then true is returned and the predicate is not evaluated */
  @Test
  public void emptyList() {
    // given
    List<String> emptyList = Collections.emptyList();
    // and
    List<String> filters = List.of("A", "B");

    // when
    // If the stream is empty then true is returned and the predicate is not evaluated.
    boolean allMatch =
        emptyList.stream() //
            .peek(el -> println("el", el))
            .allMatch(el -> filters.contains(filters));

    // then
    assertTrue(allMatch);

    // but
    assertFalse(emptyList.containsAll(filters));
  }

  @Test
  public void testSample() {
    // given
    var set = new HashSet<>(List.of("B", "C", "A"));

    // all match
    assertTrue(tryMatch(set, new TreeSet<>(List.of("B", "C", "A"))));

    // not all match
    assertFalse(tryMatch(set, new TreeSet<>(List.of("C", "A"))));

    // TODO >>> If the stream is empty then true is returned and the predicate is not evaluated.
    assertTrue(tryMatch(Collections.emptySet(), new TreeSet<>(List.of("C", "A"))));

    // analog
    assertTrue(set.containsAll(Set.of("B", "C", "A")));
  }

  private boolean tryMatch(Set<String> set, Set<String> predicates) {
    return set.stream().allMatch(predicates::contains);
  }
}
