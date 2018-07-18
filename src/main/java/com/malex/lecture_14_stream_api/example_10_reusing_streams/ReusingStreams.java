package com.malex.lecture_14_stream_api.example_10_reusing_streams;

import java.util.stream.Stream;

public class ReusingStreams {

    public static void main(String[] args) {
        Stream<String> stream =
                Stream.of("dd2", "aa2", "bb1", "bb3", "cc")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // the operation will succeed

        try {
            stream.noneMatch(s -> true);   // throws  Exception
        } catch (IllegalStateException ex) {
            // ignore
        }
    }
}
