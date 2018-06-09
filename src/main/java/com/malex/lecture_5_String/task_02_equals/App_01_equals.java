package com.malex.lecture_5_String.task_02_equals;

/**
 * Created by Alex on 3/4/2015.
 */
public class App_01_equals {

    public static void main(String[] args) {



        String str1 = new String ("Dog");

        String str2 = "Dog";

        String str3 = "Dog";

        System.out.println("str1.equals(str2) ->"+str1.equals(str2));

        System.out.print("str1==str2 -> ");
        System.out.println(str1==str2);

        System.out.print("str2==str3 -> ");
        System.out.println(str2==str3);

    }
}

