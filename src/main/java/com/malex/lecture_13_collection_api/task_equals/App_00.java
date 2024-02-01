package com.malex.lecture_13_collection_api.task_equals;

/**
 * Created by Alex on 2/17/2015.
 */
public class App_00 {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(100);
        Integer i2 = Integer.valueOf(100);

        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        //   Integer i3 = Integer.valueOf(200);
        //  Integer i4= Integer.valueOf(200);
        //   System.out.println(i3==i4);
        //   System.out.println(i3.equals(i4));

    }
}
