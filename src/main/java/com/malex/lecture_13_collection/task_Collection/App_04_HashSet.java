package com.malex.lecture_13_collection.task_Collection;


import java.util.HashSet;
import java.util.Set;

public class App_04_HashSet {

    public static void main(String[] args) {
        Set<Point2D> set = new HashSet<>();
        // add null to HashSet
        set.add(null);
        set.add(new Point2D(0,0));
        set.add(new Point2D(0,0));
        System.out.println(set);

        System.out.println(set.contains(new Point2D(0, 0)));
        System.out.println(set.remove(new Point2D(0, 0)));
        System.out.println(set);




    }


}

class Point2D{
    public final int x;
    public final int y;

    Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
