package com.malex.lecture_22_Design_Pattern.Creational;

import com.malex.lecture_22_Design_Pattern.Creational.builder.Person;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Information:
 * - https://vertex-academy.com/tutorials/ru/pattern-builder-java/
 * Base class:
 * - Person and static inner class Builder
 * Base methods:
 * - public static builder() method of person class
 * - public Person build() of builder class
 */
public class BuilderPattern {

    @Test
    public void testBuilder() {
        // given:
        String firstName = "FirstNAme";
        String lastName = "LastName";
        String email = "Email@emlau.com";
        int age = 12;

        // when:
        Person person = Person.builder().withFirstName(firstName).withLastName(lastName).withEmail(email).withAge(age).build();

        // then:
        assertNotNull(person);
        assertEquals(firstName, person.getFirstName());
        assertEquals(lastName, person.getLastName());
        assertEquals(email, person.getEmail());
        assertEquals(age, person.getAge());
    }

}
