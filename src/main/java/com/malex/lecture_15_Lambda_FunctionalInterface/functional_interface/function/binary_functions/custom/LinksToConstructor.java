package com.malex.lecture_15_Lambda_FunctionalInterface.functional_interface.function.binary_functions.custom;

import lombok.extern.java.Log;

/**
 * Links to the constructor
 *
 * @author malex
 */
@Log
public class LinksToConstructor {

    public static void main(String[] args) {
        UserBuilder builder = User::new;

        User alex = builder.createUser(21, "Alex");
        log.info(alex + "\n");

        User max = builder.createUser(20, "Max");
        log.info(max.toString());

    }
}

/**
 * Functional interface
 */
interface UserBuilder {

    User createUser(int age, String name);
}

/**
 * Entity class
 */
class User {
    private int age;
    private String name;

    User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
