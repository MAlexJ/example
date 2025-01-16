package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect.collectors.toUnmodifiableList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.malex.utils.AbstractUtils;

public class ToUnmodifiableList_method extends AbstractUtils {

    @Test
    public void test(){
        List<Integer> list = Stream.of(1, 2, 3, 4).collect(Collectors.toUnmodifiableList());

        // note: Immutable object is modified
        // list.add(6); => java.lang.UnsupportedOperationException

        println("class:", list.getClass().getName());
        println("list:", list);
    }
}
