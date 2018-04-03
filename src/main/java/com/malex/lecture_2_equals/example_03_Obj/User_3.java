package com.malex.lecture_2_equals.example_03_Obj;

public class User_3 {

    private String name;
    private int age;

    public User_3(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User_3 user_3 = (User_3) o;

        if (age != user_3.age) return false;
        return !(name != null ? !name.equals(user_3.name) : user_3.name != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "User_3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
