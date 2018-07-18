package com.malex.lecture_13_collection.task_Collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex on 14.02.2015.
 */
public class App_05_HashSet {

    public static void main(String[] args) {

        Set<Point2D_1> set = new HashSet<>();
        set.add(new Point2D_1(0, 0));
        set.add(new Point2D_1(0, 0));
        System.out.println(set);

        System.out.println(set.contains(new Point2D_1(0, 0)));
        System.out.println(set.remove(new Point2D_1(0, 0)));
        System.out.println(set);


    }
}

class Point2D_1 {
    public final int x;
    public final int y;

    Point2D_1(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * Methods ( equals(Object obj) & hashCode() ) must be agreed upon.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Point2D_1 that = (Point2D_1) obj;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        // if hashCode() -> return 0;
        // HashSet ->LinkedList. The HashSet is very slow. (Works very slowly).
        // return 0;
        // return 31*x+y; -> recommends Joshua Bloch
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return "Point2D_1{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}