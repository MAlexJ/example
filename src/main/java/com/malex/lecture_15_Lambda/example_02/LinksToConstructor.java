package com.malex.lecture_15_Lambda.example_02;

import lombok.extern.log4j.Log4j;

/**
 * Links to the constructor
 *
 * @author malex
 */
@Log4j
public class LinksToConstructor {

    public static void main(String[] args) {
        UserBuilder builder = User::new;

        User alex = builder.createUser(21, "Alex");
        log.debug(alex + "\n");

        User max = builder.createUser(20, "Max");
        log.debug(max);

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
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
