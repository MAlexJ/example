package com.malex.lecture_13_collection_api.task_Generic;

import lombok.extern.java.Log;

/**
 * Created by Alex on 04.02.2015.
 */
@Log
public class App_05_Generic {

    public static void main(String[] args) {

        Object[] ref1 = new String[]{"Mike"};
        //Error -> Generic
        //  ArrayList<Object> ref2 = new ArrayList<String>();

        String[] strArr = {"Mike"};
        Object[] objApp = strArr;
        objApp[0] = new int[]{10, 20, 30};

        log.info(objApp[0].toString());
    }
}
