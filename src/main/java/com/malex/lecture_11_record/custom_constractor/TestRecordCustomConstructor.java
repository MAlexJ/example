package com.malex.lecture_11_record.custom_constractor;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Custom Constructor in Java Records
 * link to info: <a href="https://www.baeldung.com/java-records-custom-constructor">Custom Constructor in Java Records</a>
 * <p>
 * Java Records give us greater control during object initialization by allowing for data validation and error handling
 */
public class TestRecordCustomConstructor {

    @Test
    public void testNullArgument() {
        try {
            Student s1 = new Student(null, 1, 2);
            fail();
        } catch (IllegalArgumentException ex) {
            //  not use
        }
    }

    @Test
    public void testListOfRecords() {
        List<Student> students = List.of( //
                new Student("Diana", 1, 5), //
                new Student("Alex", 3, 4), //
                new Student("Inna", 4, 2), //
                new Student("Nikolay", 11, 1));

        List<Student> arrayList = new ArrayList<>(students);
        arrayList.sort(Comparator.comparing(Student::name));
        assertEquals("Alex", arrayList.stream().findFirst().orElseThrow(IllegalArgumentException::new).name());
        // how to get last element in stream -  https://www.baeldung.com/java-stream-last-element
        // use: reduce or skip function
        assertEquals("Nikolay", arrayList.stream().reduce((first, second) -> second).orElseThrow().name());
    }
}


record Student(String name, int rollNo, int marks) {
    public Student {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
    }
}

