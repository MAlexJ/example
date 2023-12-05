package com.malex.lecture_2_statements.ExpressionStatements.lecture_2_equals.example_03_Obj;

public class User_1 {
    private String name;
    private int age;

    public User_1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User_1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
