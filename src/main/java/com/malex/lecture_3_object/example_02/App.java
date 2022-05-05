package com.malex.lecture_3_object.example_02;

import lombok.extern.java.Log;

@Log
public class App {

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        log.info("a = " + a);
        log.info("b = " + b);

        log.info("********************");
        int tmp = a;
        a = b;
        b = tmp;

        log.info("a = " + a);
        log.info("b = " + b);

        log.info("********************");

        Dog mike = new Dog(2, "mike");
        Dog hootDog = new Dog(3, "hootDog");

        log.info("mike = " + mike);
        log.info("hootDog = " + hootDog);
        log.info("********************");

        //mike = hootDog;
        //hootDog=mike;

        Dog temp = mike;
        mike = hootDog;
        hootDog = temp;

        log.info("mike = " + mike);
        log.info("hootDog = " + hootDog);

    }
}

class Dog {
    private int age;
    private String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
