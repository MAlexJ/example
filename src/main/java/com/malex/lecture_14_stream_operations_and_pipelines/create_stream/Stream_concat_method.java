package com.malex.lecture_14_stream_operations_and_pipelines.create_stream;

import java.util.stream.Stream;

public class Stream_concat_method {

    public void run(){
        Stream<Integer> iterate = Stream.iterate(1, i -> i + 1);
    }
}
