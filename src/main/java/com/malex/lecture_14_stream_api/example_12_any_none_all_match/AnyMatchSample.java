package com.malex.lecture_14_stream_api.example_12_any_none_all_match;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Returns whether any elements of this stream match the provided predicate.
 * May not evaluate the predicate on all elements if not necessary for determining the result.
 * If the stream is empty then false is returned and the predicate is not evaluated.
 * This is a short-circuiting terminal operation.
 * Params:
 * predicate – a non-interfering, stateless predicate to apply to elements of this stream
 * Returns:
 * true if any elements of the stream match the provided predicate, otherwise false
 */
public class AnyMatchSample {

    @Test
    public void test() {
        // test for list: "A", "B", "C", "D", "E"
        anyMatchForList();

        // test empty list:
        assertFalse(tyrMatch(Collections.emptyList(), Arrays.asList("X")));
        assertFalse(tyrMatch(Arrays.asList("A", "B", "C", "D", "E"), Arrays.asList("X", "z")));
    }

    private boolean tyrMatch(List<String> list, List<String> predicates) {
        return list.stream()
                .anyMatch(predicates::contains);
    }

    private void anyMatchForList() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E");

        // contains
        assertTrue(list.stream().anyMatch(el -> el.contains("A")));
        assertTrue(list.stream().anyMatch(el -> el.contains("B")));
        assertTrue(list.stream().anyMatch(el -> el.contains("C")));

        // not contains
        assertFalse(list.stream().anyMatch(el -> el.contains("XXX")));
    }

}
