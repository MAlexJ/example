package com.malex.lecture_5_random;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * <b>Generate array of random values in java 8 of using Stream API</b>
 * <p>
 * Source: http://codippa.com/how-to-generate-an-array-of-random-integers-using-stream-api-java-8/
 * <p>
 * Let’s tweak in :
 * <p>
 * #1: An error of type `java.lang.IllegalArgumentException`: bound must be greater than origin is thrown when the lower
 * and upper limit of the method ints(streamSize, lowerBound, upperBound) are same.
 * <p>
 * #2: If stream size is not supplied to `ints()` method then a `java.lang.OutOfMemoryError` is raised.
 * <p>
 * #3: Similar to `ints()` method, there are methods such as longs() and doubles() `in java.util.Random` class which generate
 * a stream for long and double values respectively.
 * <p>
 * #4: Elements of the generated array might repeat themselves.
 * <p>
 * #5: If you want to generate a list instead of an array, modify the code slightly as random.ints(10, 25,50).boxed().collect(Collectors.toList()).
 * <p>
 * #6: `boxed()` method of the stream instance returned by the `ints()` method converts the integer primitives into their wrapper `Integer` equivalent.
 * <p>
 * RESULT: Now you have another concept up your sleeve.
 *
 * @author MAlex
 * @version 1.0.0
 */
public class GenerateRandom_Arrays_or_List
{
    // When ever there is a requirement of generating random numbers, java.util.Random class comes to mind
    public static void main(String[] args)
    {
        /*
        * Following are the methods added to java.util.Random class which return a stream of integers :
        *
        * #1: `ints()` – Returns an unlimited stream of integers. This stream if directly converted to an array would result in java.lang.OutOfMemoryError.
        *
        * #2: `ints(streamSize)` – Returns a stream of specified size. This stream when converted to an array will return an array of size equal to the given stream size.
        *
        * #3: ints(streamSize, lowerBound, upperBound) – Returns a stream of specified size.
        * This stream when converted to an array will create an array of specified size with integers starting from lower bound value
        * and less than upper bound value.
        *
        * #4: ints(lowerBound, upperBound) – Same as above except the returned stream is unlimited.
        * This stream if directly converted to an array would result in java.lang.OutOfMemoryError.
        */

        // => new Random().ints(10)
        example_01();

        //
        example_02();

    }

    private static void example_02()
    {
        System.out.println("Example #2");
        Random random = new Random();
        int[] array = random.ints(10, 25, 50).toArray();
        System.out.print("ints(long streamSize, int randomNumberOrigin, int randomNumberBound) => " + Arrays.toString(array));
    }

    private static void example_01()
    {
        System.out.println("Example #1");
        IntStream ints = new Random().ints(10);
        System.out.println("new Random().ints(10); => " + Arrays.toString(ints.toArray()));
    }
}
