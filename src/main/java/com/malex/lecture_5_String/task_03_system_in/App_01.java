package com.malex.lecture_5_String.task_03_system_in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alex on 3/4/2015.
 */
public class App_01 {


    public static void main(String[] args) {

        String str = null;

        try {
            str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            System.err.println(e);
        }

        int i = Integer.valueOf(str);

        int result = i*5;
        System.out.println(">>>>>>>>>> Output " + result);
    }

}
