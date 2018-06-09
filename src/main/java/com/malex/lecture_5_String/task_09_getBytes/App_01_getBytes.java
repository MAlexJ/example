package com.malex.lecture_5_String.task_09_getBytes;

import java.io.UnsupportedEncodingException;

/**
 Description:
 This method has following two forms:
- getBytes(String charsetName):
 Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array.
- getBytes():
 Encodes this String into a sequence of bytes using the platform's default charset, storing the result into a new byte array.

 Return Value:
 This method returns the resultant byte array
 */
public class App_01_getBytes {

    public static void main(String args[]) {
        String str1 = new String("Welcome to Tutorials");

        try {
            byte[] str2 = str1.getBytes();
            System.out.println("Returned  Value " + str2);

            str2 = str1.getBytes("UTF-8");
            System.out.println("Returned  Value " + str2);

            str2 = str1.getBytes("ISO-8859-1");
            System.out.println("Returned  Value " + str2);
        } catch (UnsupportedEncodingException e) {
            System.err.println("Unsupported character set");
        }
    }

}
