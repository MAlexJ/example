package com.malex.lecture_13_collection_api.issue;

import com.google.common.collect.Sets;
import com.malex.utils.AbstractUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CheckIfListContainsElemsFromAnotherList extends AbstractUtils {
    
    @Test
    public void testJavaStreamApi() {
        // given
        List<String> first = List.of("X", "S", "X", "C", "C", "D");
        List<String> second = List.of("C", "X", "E", "E", "J", "D");
        println("first:", first);
        println("second:", second);

        assertTrue(isContainsUseJavaStream(first, second));

        // when
        List<String> commonCharacters = findElementsThatIntersect(first, second);
        println("common:", commonCharacters);

        // then
        List<String> expected = List.of("C", "D", "X");
        // and
        assertEquals(expected.size(), commonCharacters.size());
        assertTrue(expected.containsAll(commonCharacters));
    }


    private List<String> findElementsThatIntersect(List<String> initialList, List<String> verificationList) {
        return initialList.stream() //
                .filter(el -> verificationList.stream().anyMatch(e -> e.contains(el))) //
                .distinct() //
                .toList();
    }


    @Test
    public void testGuavaLibrary() {
        // given
        List<String> first = List.of("R", "S", "B", "C", "C", "D");
        List<String> second = List.of("C", "D", "E", "E");
        println("first:", first);
        println("second:", second);

        // when
        List<String> commonCharacters = findElementsThatIntersectGuava(first, second);
        println("common:", commonCharacters);

        // then
        List<String> expected = List.of("C", "D");

        // note: It will work and if orders of elements are respected
        assertEquals(expected, commonCharacters);

        // and
        assertEquals(expected.size(), commonCharacters.size());
        assertTrue(expected.containsAll(commonCharacters));
    }


    private List<String> findElementsThatIntersectGuava(List<String> initialList, List<String> verificationList) {
        var intersection = Sets.intersection(new HashSet<>(initialList), new HashSet<>(verificationList));
        return new ArrayList<>(intersection);
    }


    private boolean isContainsUseJavaStream(List<String> initialList, List<String> verificationList) {
        return initialList.stream().anyMatch(verificationList::contains);
    }

}