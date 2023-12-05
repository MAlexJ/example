package com.malex.lecture_4_sum_all_numbers;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

import static junit.framework.TestCase.assertEquals;

public class RunApp {

    public static void main(String[] args) {
        BigInteger zero = BigInteger.ZERO;
        if (Objects.isNull(args)) {
            System.out.print(zero);
            return;
        }
        BigInteger sum = Arrays.stream(args)
                .map(val -> {
                    BigInteger number = new BigInteger(val);
                    if (number.signum() == -1) {
                        throw new IllegalArgumentException("Please enter positive number, current input number - " + val);
                    }
                    return number;
                })
                .reduce(zero, BigInteger::add);
        System.out.print(sum);
    }

    @Test
    public void runAllTest() {
        testNullValue();
        testEmptyValue();
        simpleWithTwoNumbers();
        simpleTestMaxValue();
        simpleTest();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumberException() {
        // init data
        String[] inputNumbers = {"0", "-1"};
        String expected = "0";

        // test input parameters
        testAssert(inputNumbers, expected);
    }

    @Test(expected = NumberFormatException.class)
    public void testIncorrectNumber() {
        // init data
        String[] inputNumbers = {"Dima", "Alex"};
        String expected = "0";

        // test input parameters
        testAssert(inputNumbers, expected);
    }

    public void testNullValue() {
        // init data
        String expected = "0";

        // test input parameters
        testAssert(null, expected);
    }

    public void testEmptyValue() {
        // init data
        String[] inputNumbers = {};
        String expected = "0";

        // test input parameters
        testAssert(inputNumbers, expected);
    }


    public void simpleWithTwoNumbers() {
        // init data
        String[] inputNumbers = {Integer.toString(Integer.MAX_VALUE), Integer.toString(Integer.MAX_VALUE)};
        String expected = "4294967294";

        // test input parameters
        testAssert(inputNumbers, expected);
    }


    public void simpleTestMaxValue() {
        // init data
        String[] inputNumbers = {Integer.toString(Integer.MAX_VALUE), "1"};
        String expected = "2147483648";

        // test input parameters
        testAssert(inputNumbers, expected);
    }


    public void simpleTest() {
        // init data
        String[] inputNumbers = {"1", "2", "3", "4"};

        // test input parameters
        testAssert(inputNumbers, "10");
    }


    private void testAssert(String[] inputNumbers, String expected) {
        // 1.  create OutputStream for console log
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             PrintStream printStream = new PrintStream(out)) {

            // 2. Set new  OutputStream for console
            System.setOut(printStream);

            // 3. run 'main' method
            main(inputNumbers);

            // 4. console
            String consoleOutput = out.toString();
            assertEquals(expected, consoleOutput);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}