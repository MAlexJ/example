package com.malex.lecture_5_String.base.null_example;

/**
 * Created by malex on 15.06.16.
 */
public class Main {

    static class Y {
        public static String y = X.x;
    }

    static class X {
        public static String x = Y.y;
    }

    public static void main(String[] args) {
        Y.y = "a";
        System.out.println(X.x);
    }

}
