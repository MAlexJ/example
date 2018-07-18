package com.malex.lecture_13_collection.task_Vararg;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by Alex on 12.02.2015.
 */
public class App_01 {

    private final static Logger LOG = Logger.getLogger(App_00.class);

    public static void main(String[] args) {
        //  Error
        // varargFs();
        //  Error
        // varargFs(1);
        varargFs(5, 3);
        varargFs(5, 3, 2);
        varargFs(2, 3, 4, 5);
    }

    public static void varargFs(int fst, int snd, int... other) {
        LOG.debug(fst+" "+ snd+" "+Arrays.toString(other));
    }


}
