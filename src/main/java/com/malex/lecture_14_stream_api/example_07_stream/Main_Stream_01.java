package com.malex.lecture_14_stream_api.example_07_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main_Stream_01 {

    public static void main(String[] args) {
        List<String> mList = Arrays.asList("aa1", "cc2", "cc1", "aa2", "bb1");
        mList
                .stream()
                .filter(list -> list.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        Arrays.asList("cc1", "cc2", "cc3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\n~~~~~~~~~~~~~~~~~\n");

        Stream.of("cc1", "cc2", "cc3")
                .findFirst()
                .ifPresent(System.out::println);

    }
}
