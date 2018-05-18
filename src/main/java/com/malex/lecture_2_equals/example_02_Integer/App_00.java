package com.malex.lecture_2_equals.example_02_Integer;

/**
 * Conclusion: you can not compare reference variables ==, only equals()
 */
public class App_00
{
    public static void main(String[] args)
    {
        Integer i1 = 128;
        Integer i2 = 128;

        System.out.println(i1);
        System.out.println(i1.equals(i2));

        //Integer in = Integer.valueOf(100);
        //static final int low = -128;
        // static final int high = 127;

        // public static Integer valueOf(int i) {
        //    if (i >= IntegerCache.low && i <= IntegerCache.high)
        //        return IntegerCache.cache[i + (-IntegerCache.low)];
        //   return new Integer(i);
        // }
    }
}
