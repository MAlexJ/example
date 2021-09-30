package com.malex.lecture_13_collection.issue;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CheckIfListContainsAneElemsFromAnotherList {

    @Test
    public void test() {
        List<String> initialList = Lists.newArrayList("A", "B", "C", "C", "D");
        List<String> verificationList = Lists.newArrayList("C", "D", "E", "E");
        assertTrue(isContainsUseJavaStream(initialList, verificationList));

        assertEquals(Lists.newArrayList("C", "D"), findElementsThatIntersectGuava(initialList, verificationList));
        assertEquals(Lists.newArrayList("C", "D"), findElementsThatIntersect(initialList, verificationList));

    }

    private List<String> findElementsThatIntersectGuava(List<String> initialList, List<String> verificationList) {
        return new ArrayList<>(Sets.intersection(new HashSet<>(initialList), new HashSet<>(verificationList)));
    }

    private List<String> findElementsThatIntersect(List<String> initialList, List<String> verificationList) {
        return initialList.stream()
                .filter(el -> verificationList.stream().anyMatch(e -> e.contains(el)))
                .distinct()
                .collect(Collectors.toList());
    }


    private boolean isContainsUseJavaStream(List<String> initialList, List<String> verificationList) {
        return initialList.stream()
                .anyMatch(verificationList::contains);
    }

}
