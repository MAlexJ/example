package com.malex.lecture_13_collection.task_Vararg;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by Alex on 12.02.2015.
 */
public class App_00 {

    private final static Logger LOG = Logger.getLogger(App_00.class);

    public static void main(String[] args) {
        f(new int[]{1});
        f(new int[]{1, 2, 4, 5});
        f(new int[]{3, 2, 5, 7});
        LOG.debug(Arrays.toString(args));
        varargF();
        varargF(1);
        varargF(2, 3, 4, 5);
        varargF(5, 3, 2);

    }

    public static void f(int[] args) {
        LOG.debug(Arrays.toString(args));
    }

    public static void varargF(int... args) {
        int[] arr = args;
        LOG.debug(Arrays.toString(args));
    }


    public static void varargStr(String str, int... args) {
        LOG.debug(Arrays.toString(args));
    }

    //Error
    // Vararg parameter must be the last in the lis
    //public static void varargStr1 (String... s, String str) {  LOG.debug(s);  }

    //Error
    // Vararg parameter must be the last in the lis
    // public static void varargStr (String... s,int... args) {  int[] arr = args;  LOG.debug(Arrays.toString(args));  }


}
