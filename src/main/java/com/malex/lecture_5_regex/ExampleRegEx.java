package com.malex.lecture_5_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleRegEx
{

    public static void main(String[] args)
    {
        // ****  1  ******
//        String string = "aAd";
//        Pattern pt = Pattern.compile("[a-z][A-Z][a-z]");

        // ****  2  ******
//        String string = "K";
//        Pattern pt = Pattern.compile("[a-zA-Z]");

        // ****  3  ******
//        String string = "Kd";
//        Pattern pt = Pattern.compile("[a-zA-Z]{2}");

        // ****  4  ******
//        String string = "Kd";
//        Pattern pt = Pattern.compile("[a-zA-Z]{1,2}");

        // ****  5  ******
        String string = "123123535123.5";
        Pattern pt = Pattern.compile("[0-9|.]+");

        // ****  6  ******
//        String string = "AvKd81";
//        Pattern pt = Pattern.compile("[a-zA-Z0-9&&[^f0]]{0,10}");

        // ****  7  ******
//        String string = "AvKd81 ";
//        Pattern pt = Pattern.compile("[a-zA-Z0-9&&[^f0]]{0,10}[\\s]");

        // ****  8  ******
//        String string = "AvKd81_";
//        Pattern pt = Pattern.compile("\\w*");

        // ****  9  ******
//        String string = "AvKd81_";
//        Pattern pt = Pattern.compile("^A.*\\w$");

        Matcher mt = pt.matcher(string);
        boolean flag = mt.matches();

        System.out.println(flag);
    }
}
