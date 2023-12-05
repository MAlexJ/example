package com.malex.lecture_2_statements.ExpressionStatements.lecture_2_equals.example_01_String;

import java.util.Arrays;

/**
 * Created by Alex on 2/17/2015.
 */
public class App_03 {

    public static void main(String[] args) {

        //*****************************************
        char[] arrChar = {'a', 'b', 'c', 'd'};
        String str = new String(arrChar);
        System.out.println(str);

        //*****************************************
        String str1 ="System.out.println(str);";
        char[] chars = str1.toCharArray();
        System.out.println(Arrays.toString(chars));
    }
}
