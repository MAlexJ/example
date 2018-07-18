package com.malex.lecture_1_primitive.example_2;

/**
 * In case of abbreviated operations in java, type casting is performed.
 * That is, v1 + = v2 is analogous to v1 = (int) (v1 + v2)
 * Accordingly, the first line will have a compilation error since long is wider than int,
 * and the second line will be successfully executed.
 */
public class AppPrimitive
{
    public static void main(String[] args)
    {
        int numInt = 1;
        long numLong = 2;

        //??????
        //numInt += numLong;
        //?????
        //numInt = numInt + numLong;
    }
}

