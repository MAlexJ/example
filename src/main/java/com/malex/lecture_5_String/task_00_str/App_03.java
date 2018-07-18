package com.malex.lecture_5_String.task_00_str;

/**
 * Created by Alex on 3/4/2015.
 */
public class App_03 {

    public static void main(String[] args) {

        char[] arr = {'a','b','c','d'};
        String str = new String (arr);
        System.out.println(str);

        String str1 = new String(arr,1,3);
        System.out.println(str1);
    }
}
