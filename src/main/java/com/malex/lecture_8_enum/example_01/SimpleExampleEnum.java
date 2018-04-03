package com.malex.lecture_8_enum.example_01;

import java.util.Arrays;

/**
 * Simple example enum
 *
 * @author malex
 */
public class SimpleExampleEnum {

    public static void main(String[] args) {
        /*
        EXAMPLE #1
         */
        System.out.println(ThreadStatesEnum.START);
        System.out.println(ThreadStatesEnum.DEAD + "\n");

        /*
        EXAMPLE #2
        Enum.valueOf(String name);
        */
        String str = "WAITING";
        System.out.println(ThreadStatesEnum.valueOf(str) + "\n");

        /*
        EXAMPLE #3
        Incorrect name -> Enum.valueOf(String name);
        */
        try {
            String st = "THE END";
            ThreadStatesEnum.valueOf(st);
        } catch (IllegalArgumentException ex) {
            System.out.println(" >>>> " + ex.getMessage() + "\n");
        }

        /*
        EXAMPLE #4
        Array -> Enum.values();
        */
        ThreadStatesEnum[] values = ThreadStatesEnum.values();
        System.out.println(Arrays.toString(values) + "\n");

         /*
        EXAMPLE #5
        Enum -> ordinal();
        */
        System.out.println(ThreadStatesEnum.RUNNING + " ordinal:" + ThreadStatesEnum.RUNNING.ordinal());
        System.out.println(ThreadStatesEnum.WAITING + " ordinal:" + ThreadStatesEnum.WAITING.ordinal() + "\n");
    }
}
