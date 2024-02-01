package com.malex.lecture_5_String.base.task_12_replace;

/**
 Description:
 This method returns a new string resulting from replacing all occurrences
 of oldChar in this string with newChar.

 Syntax:
 Here is the syntax of this method:
 public String replace(char oldChar, char newChar)

 Return Value:
 It returns a string derived from this string by replacing every occurrence of oldChar with newChar.

 */
public class App_01_replace {

    public static void main(String args[]){
        String Str = new String("Welcome to Tutorialspoint.com");

        System.out.println("Str.replace('o', 'T') -> ");
        System.out.println(Str.replace('o', 'T')+" :Str.replace('o', 'T')");

        System.out.println();

        System.out.println("Str.replace('l', 'D') -> ");
        System.out.println(Str.replace('l', 'D')+" :Str.replace('l', 'D')");
    }
}
