package com.malex.lecture_14_stream_api.example_06_group_by;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * A simple example of using the method 'group' of Stream API
 */
@Log4j
public class GroupingByStreamSample {

    public static void main(String[] args) {
        //example_01
        use_collect_grouping_by(
                new Phone("iPhone 6 S", "Apple", 600),
                new Phone("Lumia 950", "Microsoft", 500),
                new Phone("iPhone 5 S", "Apple", 450),
                new Phone("Lumia 640", "Microsoft", 200)
        );
    }

    private static void use_collect_grouping_by(Phone... phones) {
        log.info("Example_01");

        Stream<Phone> phoneStream = Stream.of(phones);

        Map<String, List<Phone>> phonesByCompany = phoneStream.collect(
                Collectors.groupingBy(Phone::getCompany));

        for (Map.Entry<String, List<Phone>> item : phonesByCompany.entrySet()) {

            System.out.println(item.getKey());
            for (Phone phone : item.getValue()) {

                System.out.println(phone.getName());
            }
            System.out.println("");
        }

    }

    @Getter
    @RequiredArgsConstructor
    private static class Phone {
        @NonNull
        private String name;
        @NonNull
        private String company;
        @NonNull
        private Integer price;
    }
}
