package com.malex.lecture_5_String.example_02_equals;

import lombok.extern.java.Log;

@Log
public class SrtingEquals {
    public static void main(String[] args) {

        String str1 = new String("Dog");

        String str2 = "Dog";

        String str3 = "Dog";

        log.info("str1.equals(str2) -> " + str1.equals(str2));
        log.info("str1==str2 -> " + (str1 == str2));
        log.info("str2==str3 -> " + (str2 == str3));
    }
}
