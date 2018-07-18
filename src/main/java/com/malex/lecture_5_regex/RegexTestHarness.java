package com.malex.lecture_5_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness
{

    public static void main(String[] args)
    {
//        System.out.println(test1("JAVA_HOME"));
//        System.out.println(test1(" JAVA_HOME"));
//        System.out.println(test1(" JAVA_HOME "));
//        System.out.println(test1(" JAVA_OME"));

        System.out.println(test2("trololo.com"));     //true
        System.out.println(test2("trololo.ua "));     //false
        System.out.println(test2("trololo.ua"));      //true
        System.out.println(test2("trololo/ua"));      //false
        System.out.println(test2("i love java because it is cool.ru"));      //true
        System.out.println(test2("BACON.ru"));        //true
        System.out.println(test2("BACON.de"));        //false
    }

    // the method to check the string for the content in it JAVA_HOME
    private static boolean test1(String testString)
    {
        Pattern p = Pattern.compile("^JAVA_HOME$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    // The method of checking that the string ends with .com or .ru or .ua.
    private static boolean test2(String testString)
    {
        Pattern p = Pattern.compile(".+\\.(com|ua|ru)");
        Matcher m = p.matcher(testString);
        return m.matches();
    }
}
