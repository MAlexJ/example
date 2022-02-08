package com.malex.lecture_22_Design_Pattern.Creational.builder;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private int age;


    /**
     * Allows to get the builder for the Person
     *
     * @return builder
     */
    public static Builder builder() {
        return new Builder();
    }

    private Person(Builder builder) {
        log.info("Person constructor");
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.age = builder.age;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private int age;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}