package com.malex.lecture_14_stream_api.example_11_any_none_all_match;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Returns whether no elements of this stream match the provided predicate.
 * May not evaluate the predicate on all elements if not necessary for determining the result.
 * If the stream is empty then true is returned and the predicate is not evaluated.
 * This is a short-circuiting terminal operation.
 * Params:
 * predicate – a non-interfering, stateless predicate to apply to elements of this stream
 * Returns:
 * true if either no elements of the stream match the provided predicate or the stream is empty, otherwise false
 */
public class NoneMatchSample {

    @Test
    public void test() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);

        // nome match
        assertTrue(tryMatch(list, Lists.newArrayList(6, 7, 8)));
        assertTrue(tryMatch(Collections.emptyList(), Lists.newArrayList(6, 7, 8)));

        // match
        assertFalse(tryMatch(list, Lists.newArrayList(5, 7, 8)));
        assertFalse(tryMatch(list, Lists.newArrayList(0, 1)));
    }

    private boolean tryMatch(List<Integer> list, ArrayList<Integer> predicates) {
        return list.stream()
                .noneMatch(predicates::contains);
    }

}
