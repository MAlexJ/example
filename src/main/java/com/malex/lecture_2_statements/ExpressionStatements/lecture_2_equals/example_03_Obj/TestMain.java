package com.malex.lecture_2_statements.ExpressionStatements.lecture_2_equals.example_03_Obj;

/**
 * Created by alex on 14.06.15.
 */
public class TestMain {

    public static void main(String[] args) {

        User_1 user1 = new User_1("Anna", 20);
        User_1 user2 = new User_1("Anna", 20);

        System.out.println(user1.equals(user2));

        User_2 user3 = new User_2("Anna11", 20);
        User_2 user4 = new User_2("Anna222", 20);

        System.out.println(user3.equals(user4));

        User_3 user5 = new User_3("Anna", 20);
        User_3 user6 = new User_3("Anna", 20);

        System.out.println(user5.equals(user6));
    }
}
