package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.mapTo.mapToInt;

import java.util.OptionalInt;
import java.util.stream.Stream;

import org.junit.Test;

import com.malex.utils.AbstractUtils;

public class MapToInt_method extends AbstractUtils {

    @Test
    public void mapToInt(){
        OptionalInt maxOpt = Stream.of(-1, 4, 3, 10, -23).mapToInt(i -> i).max();
        maxOpt.ifPresent(this::println);
    }

}
