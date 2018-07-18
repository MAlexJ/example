package com.malex.lecture_13_collection.task_Generic;

import java.util.ArrayList;

/**
 * Created by Alex on 06.02.2015.
 */
public class App_07_Generic {

    public static void main(String[] args) {

        ArrayList<? extends Integer> ref0 = null;
        ArrayList<? extends Number> ref1 = null;

        // error ->  ref0=ref1;
        ref1=ref0;


        ArrayList<? super Integer> ref2 = null;
        ArrayList<? super Number> ref3 = null;

        ref2=ref3;
        // error ->  ref3=ref2;

    }

}
