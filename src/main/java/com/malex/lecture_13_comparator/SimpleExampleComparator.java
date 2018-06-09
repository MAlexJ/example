package com.malex.lecture_13_comparator;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

public class SimpleExampleComparator
{
    private static final char CHAR_X = 'x';
    private static final Comparator<String> STRING_COMPARATOR = (s1, s2) ->
    {
        long num = s2.chars().filter(c -> c == CHAR_X).count() - s1.chars().filter(c -> c == CHAR_X).count();
        return (int) num;
    };

    public static void main(String[] args)
    {
        List<String> aStrings = Lists.newArrayList("718", "alex", "max", "xxx", "x_x_x_x", "anna");
        System.out.println("The list before sorting: \n" + aStrings);
        aStrings.sort(STRING_COMPARATOR);
        System.out.println("\nThe list after sorting by number of char 'x': \n" + aStrings);
    }
}
