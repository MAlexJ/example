package com.malex.lecture_14_stream_api.example_11_any_none_all_match;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * Returns whether no elements of this stream match the provided predicate. May not evaluate the
 * predicate on all elements if not necessary for determining the result. If the stream is empty
 * then true is returned and the predicate is not evaluated. This is a short-circuiting terminal
 * operation. Params: predicate – a non-interfering, stateless predicate to apply to elements of
 * this stream Returns: true if either no elements of the stream match the provided predicate or the
 * stream is empty, otherwise false
 */
public class NoneMatch extends AbstractUtils {

  @Test
  public void emptyList() {
    // given
    List<String> emptyList = Collections.emptyList();
    // and
    List<String> filters = List.of("A", "B");

    // when
    // If the stream is empty then true is returned and the predicate is not evaluated.
    boolean noneMatch =
        emptyList.stream() //
            .peek(el -> println("el", el))
            .noneMatch(el -> filters.contains(filters));

    // then
    assertTrue(noneMatch);
  }

  @Test
  public void collectionTest() {
    var numbers = List.of(1, 2, 3, 4, 5);

    // nome match
    assertTrue(tryMatch(numbers, List.of(6, 7, 8)));
    assertTrue(tryMatch(Collections.emptyList(), List.of(6, 7, 8)));

    // match
    assertFalse(tryMatch(numbers, List.of(5, 7, 8)));
    assertFalse(tryMatch(numbers, List.of(0, 1)));
  }

  private boolean tryMatch(List<Integer> list, List<Integer> predicates) {
    return list.stream().noneMatch(predicates::contains);
  }

  @Test
  public void textDoesNotContainListOfWords() {
    // given
    var text = "Test my impl and none match";
    var keyWords = List.of("dog", "cat", "word");

    // when
    boolean noneMatch =
        keyWords.stream()
            .peek(key -> println("key:", key))
            .noneMatch(key -> text.toLowerCase().contains(key.toLowerCase()));

    // then
    assertTrue(noneMatch);
  }

  @Test
  public void textContainListOfWords() {
    // given
    var text = "Test my impl and none match";
    var keyWords = List.of("Test", "cat", "and");

    // when
    boolean noneMatch =
        keyWords.stream()
            .peek(key -> println("key:", key))
            .noneMatch(key -> text.toLowerCase().contains(key.toLowerCase()));

    // then
    assertFalse(noneMatch);
  }
}
