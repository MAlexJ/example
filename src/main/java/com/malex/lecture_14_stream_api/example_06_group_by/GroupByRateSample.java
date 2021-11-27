package com.malex.lecture_14_stream_api.example_06_group_by;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class GroupByRateSample {

    private static final List<Integer> RATE_LIST =
            Lists.newArrayList(1, 2, 1, 5, 3, 2, 2, 2, 1, 2, 5, 4, 1, 2, 2, 2, 2, 4, 4);

    /**
     * group the list by the number of occurrences
     */
    @Test
    public void groupRateListByNumberOfOccurrences() {
        // when:
        Map<Integer, List<Integer>> map = RATE_LIST.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.toList()));

        // then: test first element
        Map.Entry<Integer, List<Integer>> firstElem = map.entrySet().stream().findFirst().orElseThrow(IllegalArgumentException::new);
        assertEquals(firstElem.getKey().intValue(), 1);
        assertEquals(firstElem.getValue().size(), 4);

        // and: test second element
        Map.Entry<Integer, List<Integer>> secondElement = findElemByPosition(1, map);
        assertEquals(secondElement.getKey().intValue(), 2);
        assertEquals(secondElement.getValue().size(), 9);

        // and: last element
        Map.Entry<Integer, List<Integer>> lastElement = findElemByPosition(4, map);
        assertEquals(lastElement.getKey().intValue(), 4);
        assertEquals(lastElement.getValue().size(), 1);
    }

    @Test
    public void groupByCount() {
        // when
        Map<Integer, Long> rates = RATE_LIST.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // then
        assertEquals(rates.get(5).intValue(), 2);
        assertEquals(rates.get(3).intValue(), 1);
        assertEquals(rates.get(2).intValue(), 9);
    }

    @Test
    public void groupByMinRate() {
        // given
        Map<Integer, Long> rates = RATE_LIST.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // then:
        Map<Integer, Long> sortedRates = rates.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));

        // and:
        List<Integer> rateList = new ArrayList<>(sortedRates.keySet());

        // test
        assertEquals(rateList.get(0).intValue(), 3);
        assertEquals(rateList.get(4).intValue(), 2);
    }

    @Test
    public void groupByMAxRate() {
        // given
        Map<Integer, Long> rates = RATE_LIST.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // then:
        List<Integer> sortedRateList = rates.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // test
        assertEquals(sortedRateList.get(0).intValue(), 2);
        assertEquals(sortedRateList.get(4).intValue(), 3);
    }

    private Map.Entry<Integer, List<Integer>> findElemByPosition(int position, Map<Integer, List<Integer>> map) {
        Object key = map.keySet().toArray()[position];
        return map.entrySet().stream()
                .filter(e -> e.getKey().equals(key))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
