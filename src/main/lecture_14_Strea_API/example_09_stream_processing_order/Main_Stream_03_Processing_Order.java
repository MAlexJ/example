package example_09_stream_processing_order;

import java.util.stream.Stream;

public class Main_Stream_03_Processing_Order {

    public static void main(String[] args) {

        // No terminal operations
        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    System.out.println("Фильтр: " + s);
                    return true;
                });

        System.out.println("\n~~~~~~~~~~~~~~\n");

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    System.out.println("Фильтр: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("Печать с использованием forEach: " + s));

        System.out.println("\n~~~~~~~~~~~~~~\n");

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });


        System.out.println("\n~~~~~~~~~~~~~~\n");

        // task 1
        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .map(s -> {
                    System.out.println("  map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("    filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("\n~~~~~~~~~~~~~~\n");

        // simplification of the task 1
        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));


        System.out.println("\n~~~~~~~~~~~~~~\n");

        // Сортировка является особым видом промежуточных операций. Это так называемые операции состояния.
        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("\n~~~~~~~~~~~~~~\n");

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

    }
}
