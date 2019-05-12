package com.malex.lecture_25_Java_8.example_08_flatMap;

import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * flatMap(...) - Returns a stream consisting of the results of replacing each element of
 * this stream with the contents of a mapped stream produced by applying
 * the provided mapping function to each element.
 */
@Log4j
public class FlatMapExample {

    public static void main(String[] args) {

        int start = 0;
        int end = 5;
        List<List<Integer>> generalList = new ArrayList<>();

        IntStream.range(start, end).forEach(value -> {
            log.info(value);
            int startShift = value + 1;
            int endShift = value + end;
            generalList.add(IntStream.range(startShift, endShift)
                    .boxed()
                    .collect(Collectors.toList()));
        });

        List<Integer> result = generalList.stream().flatMap(Collection::stream)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        log.info(result);
    }
}
