package com.malex.lecture_14_stream_api.example_02_filtering_sorting_and_display_elements;

import java.util.stream.Stream;

/**
 * @author malex
 */
public class Main_Stream_API_02 {

    public static void main(String[] args) {
        // forEach
        use_forEach();

        // simple filter
        use_simple_filter();

        // filter object
        use_filter();

        // map
        use_map();

        // flatMap
        use_flatMap();
    }

    /**
     *
     */
    private static void use_forEach() {
        init("FOREACH");

        Stream<String> cities = Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель");
        cities.forEach(System.out::println);

        init();
    }

    /**
     *
     */
    private static void use_simple_filter() {
        init("SIMPLE FILTER");

        Stream<String> citiesStream = Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель");
        citiesStream.filter(city -> city.length() > 6).forEach(System.out::println);

        init();
    }

    /**
     *
     */
    private static void use_filter() {
        init("FILTER");

        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));

        phoneStream.filter(p -> p.getPrice() > 44000).forEach(System.out::println);

        init();
    }

    /**
     * Simple example of using the method {@see map}.
     * <R> Stream<R> map(Function<? super T, ? extends R> mapper)
     */
    private static void use_map() {
        init("MAP");

        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));
        phoneStream.map(p -> p.getName() + "  " + p.getPrice()).forEach(System.out::println);


        init();
    }

    /**
     * Simple example of using the method {@see flatMap}
     * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
     */
    private static void use_flatMap() {
        init("FLAT_MAP");

        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));
        phoneStream.flatMap(Main_Stream_API_02::phonesStream)
                .forEach(System.out::println);

        init();
    }

    private static Stream<String> phonesStream(Phone p) {
        return Stream.of(p.getName());
    }

    /**
     * Entity class
     */
    private static class Phone {

        private String name;
        private int price;

        Phone(String name, int price) {
            this.name = name;
            this.price = price;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Phone{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }


    /**
     * Print log
     *
     * @param str log message
     */
    private static void init(String... str) {
        if (str.length > 0)
            System.out.println("---------- " + str[0] + " ----------");
        else
            System.out.println();
    }
}
