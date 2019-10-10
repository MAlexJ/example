package com.malex.lecture_25_Java_8.example_01_predicate_interface;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j
public class PredicateInterfaceMain {

    private static final String FILTER_OLD = "Older";
    private static final String FILTER_YOUNG = "Younger";

    public static void main(String[] args) {

        List<Person> people = Stream.
                of(
                        new Person("Mike", 75),
                        new Person("Abdul", 20),
                        new Person("Anna", 18),
                        new Person("Max", 33),
                        new Person("Alex", 32)
                )
                .collect(Collectors.toList());

        Predicate<Person> predicateOlder = person -> person.getAge() >= 65;
        Predicate<Person> predicateYounger = person -> person.getAge() <= 40;

        displayPeople(people, predicateOlder, FILTER_OLD);
        displayPeople(people, predicateYounger, FILTER_YOUNG);

    }

    private static void displayPeople(List<Person> people, Predicate<Person> predicate, String nameOfPredicate) {
        people.forEach(p -> {
            if (predicate.test(p)) {
                log.debug(String.format("Predicate %s : Person %s; %n", nameOfPredicate, p));
            }
        });
    }
}

@Getter
@Setter
class Person {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}