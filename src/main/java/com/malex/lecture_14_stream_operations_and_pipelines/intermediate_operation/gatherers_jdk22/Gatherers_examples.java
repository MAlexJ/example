package com.malex.lecture_14_stream_operations_and_pipelines.intermediate_operation.gatherers_jdk22;

import java.util.stream.Gatherers;
import java.util.stream.Stream;

import org.junit.Test;

import com.malex.utils.AbstractUtils;

public class Gatherers_examples  extends AbstractUtils {

    @Test
    public void test(){
        Stream.of("a", "b", "c", "d", "e", "f", "g", "h")
                .gather(Gatherers.fold(()->"", (joined, element) -> joined + element))
                .forEach(this::println); //abcdefgh


        Stream.of("a", "b", "c", "d", "e", "f", "g", "h")
                .gather(Gatherers.scan(()->"", (joined, element) -> joined + element))
                .forEach(System.out::println); //a, ab, abc, abcd, abcde, abcdef, abcdefg, abcdefgh
    }
}
