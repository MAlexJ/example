package com.malex.lecture_5_String.task_10_indexOf;

/**
 * Created by Alex on 06.03.2015.
 */
public class App_02_indexOf {

    public static void main(String args[]) {
        String str = new String("Welcome to Tutorials");
        String subStr1 = new String("Tutorials");
        String subStr2 = new String("Sutorials");

        System.out.print("Found Index :" );
        System.out.println( str.indexOf( subStr1 ) +"  :");

        System.out.print("Found Index :" );
        System.out.println( str.indexOf( subStr1, 8 ) +"  :");

        System.out.print("Found Index :" );
        System.out.println(str.indexOf( subStr2 ) +"  :");
    }

}
