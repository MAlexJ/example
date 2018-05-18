package com.malex.lecture_5_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExReplaceText
{

    private static String text = "I really like Thailand. Thailand is where I would go. thailand - dreams come true!";

    public static void main(String[] args)
    {

//        System.out.println(text.replaceAll("[Тт]а[ий]ланд", "Украина"));
//
//        System.out.println(test_queue("rrrr"));

        // Pattern p = Pattern.compile("^[a-z]{0,}");
        Pattern p = Pattern.compile("^0.[0]+");
        Matcher m = p.matcher("0.0000");
        System.out.println(m.matches());
    }

    /**
     * Inside the character classes there are their own metacharacters:
     *      ^ - logical NOT. For example, [^ ABC] is not A or B or C, but all other characters are appropriate.
     *      - - (hyphen) character spacing; Thus, the expression <H [1-6]> is equivalent to <H [123456]>
     */
    public static boolean test(String testString)
    {
        //"^[a-z]+" = the beginning of the line + any character within a-z (abcdef ... z) any number of times (from one).
        // Pattern p = Pattern.compile("^[a-z]{0,}");
        Pattern p = Pattern.compile("^[a-z]+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    public static boolean test1(String testString)
    {
        //"^[a-z]+" = the beginning of the line + any character within a-z (abcdef ... z) any number of times (from one).
        Pattern p = Pattern.compile("^[^a-z]+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }
}
