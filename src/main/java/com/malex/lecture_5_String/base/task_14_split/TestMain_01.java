package com.malex.lecture_5_String.base.task_14_split;

import java.util.Arrays;

/**
 * Created by Alex on 10/18/2015.
 */
public class TestMain_01 {

    public static void main(String[] args) {

        String s = "connect|user|data|ioo";

        String[] split = s.split("\\|");

        System.out.println(Arrays.toString(split));
        System.out.println(split.length);


    }
}
