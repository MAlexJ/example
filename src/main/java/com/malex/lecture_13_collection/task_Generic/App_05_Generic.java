package com.malex.lecture_13_collection.task_Generic;

import org.apache.log4j.Logger;

/**
 * Created by Alex on 04.02.2015.
 */
public class App_05_Generic {
    private final static Logger LOG = Logger.getLogger(App_05_Generic.class);

    public static void main(String[] args) {

        Object[] ref1 = new String[]{"Mike"};
        //Error -> Generic
        //  ArrayList<Object> ref2 = new ArrayList<String>();

        String[] strArr = {"Mike"};
        Object[] objApp = strArr;
        objApp[0] = new int[]{10,20,30};

        if (LOG.isDebugEnabled()) {
            LOG.debug(objApp[0]);


        }
    }
}
