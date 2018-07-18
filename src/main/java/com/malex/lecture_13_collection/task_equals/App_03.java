package com.malex.lecture_13_collection.task_equals;

/**
 * Created by Alex on 2/17/2015.
 */
public class App_03 {

    public static void main(String[] args) {

        // Point2D -> not override hashCode & equals
        System.out.println("Point2D -> not override hashCode & equals");
        Point2D po1 = new Point2D(0,0);
        Point2D po2 = new Point2D(0,0);
        System.out.println(po1==po2);
        System.out.println(po1.equals(po2));


        // Point2D_equals -> not override equals
        System.out.println("Point2D_equals -> not override equals");
        Point2D_equals poEq1 = new Point2D_equals(1,1);
        Point2D_equals poEq2 = new Point2D_equals(1,1);
        System.out.println(poEq1==poEq2);
        System.out.println(poEq1.equals(poEq2));


        // Point2D_Eql_Hash -> override hashCode & equals
        System.out.println("Point2D_Eql_Hash -> override hashCode & equals");
        Point2D_Eql_Hash point1 = new Point2D_Eql_Hash(1, 1);
        Point2D_Eql_Hash point2 = new Point2D_Eql_Hash(1, 1);
        System.out.println(point1 == point2);
        System.out.println(point1.equals(point2));

    }
}
