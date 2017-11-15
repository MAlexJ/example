package example_01_predicate_interface;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                System.out.printf("Predicate %s : Person %s ; \n", nameOfPredicate, p);
            }
        });
    }
}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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