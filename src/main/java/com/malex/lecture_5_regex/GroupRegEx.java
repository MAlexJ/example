package com.malex.lecture_5_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 01.07.15.
 */
public class GroupRegEx
{

    public static void main(String[] args)
    {

//        Pattern p = Pattern.compile("(I am a king).+(\\1)");
//        Matcher m = p.matcher("regular expressions are cool regular expressions this is cool regular expressions this is cool anchor I TODAY EL BANANA anchor regular expressions this is cool" );
//        if(m.find()){
//            System.out.println(m.group());
//        }

        Pattern p = Pattern.compile("(<h1>).+(\\1)");
        // On the site of the first group (the anchor) could contain a more complex expression, then the back reference \\ 1 significantly reduced
        // would be the size of the regular expression.
        Matcher matcher = p.matcher("<hjejej>   <h1> ffffff <h1> sdsff<h2>addda <h12> ggggg <h12>");
        if (matcher.find())
        {
            System.out.println("match: " + matcher.group());
        }
    }
}
