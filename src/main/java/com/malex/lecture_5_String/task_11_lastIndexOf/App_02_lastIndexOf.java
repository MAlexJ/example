package com.malex.lecture_5_String.task_11_lastIndexOf;


public class App_02_lastIndexOf {

    public static void main(String args[]) {
        String str = new String("Welcome to Tutorialspoint");
        String subStr1 = new String("Tutorials");
        String subStr2 = new String("Sutorials");


        System.out.print("Found Last Index :");
        System.out.println(str.lastIndexOf(subStr1));

        System.out.print("Found Last Index :");
        System.out.println(str.lastIndexOf(subStr1, 15));

        System.out.print("Found Last Index :");
        System.out.println(str.lastIndexOf(subStr2));
    }

}
