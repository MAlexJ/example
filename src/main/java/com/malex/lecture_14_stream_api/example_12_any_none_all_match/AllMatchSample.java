package com.malex.lecture_14_stream_api.example_12_any_none_all_match;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Returns whether all elements of this stream match the provided predicate.
 * May not evaluate the predicate on all elements if not necessary for determining the result.
 * If the stream is empty then true is returned and the predicate is not evaluated.
 * This is a short-circuiting terminal operation.
 * Params:
 * predicate – a non-interfering, stateless predicate to apply to elements of this stream
 * Returns:
 * true if either all elements of the stream match the provided predicate or the stream is empty, otherwise false
 */
public class AllMatchSample {

    @Test
    public void test() {

        Set<String> set = new HashSet<>(Arrays.asList("B", "C", "A"));
        Set<String> predicates = new TreeSet<>(set);

        // all match
        assertTrue(tryMatch(set, predicates));

        // not all match
        assertFalse(tryMatch(set, new TreeSet<>(Arrays.asList("C", "A"))));

        // TODO >>> If the stream is empty then true is returned and the predicate is not evaluated.
        assertTrue(tryMatch(Collections.emptySet(), new TreeSet<>(Arrays.asList("C", "A"))));
    }

    private boolean tryMatch(Set<String> set, Set<String> predicates) {
        return set.stream()
                .allMatch(predicates::contains);
    }

}
