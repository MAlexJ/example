package com.malex.lecture_5_String.task_00_str;

/**
 * Created by Alex on 06.03.2015.
 */
public class App_06_Concatenating {
    public static void main(String[] args) {
        String str1 = "First";
        String str2 = "Second";
        //concat(String str);
        String strResult = str1.concat(str2);

        System.out.println("str1 -> " + str1);
        System.out.println("str2 -> " + str2);
        System.out.println("strResult -> " + strResult);
    }

}
