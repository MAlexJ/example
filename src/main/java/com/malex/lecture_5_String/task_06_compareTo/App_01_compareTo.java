package com.malex.lecture_5_String.task_06_compareTo;

/**
 *Description:
 *  There are two variants of this method.
 *  First method compares this String to another Object
 *  and second method compares two strings lexicographically.
 *
 *  Syntax:
 *  - int compareTo(Object o);
 *  - int compareTo(String anotherString);
 *
 *  Return Value :
 *  The value 0 if the argument is a string lexicographically equal to this string;
 *  a value less than 0 if the argument is a string lexicographically greater than this string;
 *  a value greater than 0 if the argument is a string lexicographically less than this string.
 */
public class App_01_compareTo {

    public static void main(String args[]) {
        String str1 = "Strings are immutable";
        String str2 = "Strings are immutable";
        String str3 = "Integers are not immutable";

        int result = str1.compareTo(str2);
        System.out.println(result);

        result = str2.compareTo(str3);
        System.out.println(result);

        result = str3.compareTo(str1);
        System.out.println(result);
    }
}
