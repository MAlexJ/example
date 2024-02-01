package com.malex.lecture_13_collection_api.task_Collection;

import java.util.Set;
import java.util.TreeSet;

public class App_07_TreeSet {

    //??????
    public static void main(String[] args) {
        Set<Point2> set =new TreeSet<>();
        set.add(new Point2(1,1));
        set.add(new Point2(2,1));
        set.add(new Point2(4,3));
        System.out.println(set);
    }
}

class Point2 implements  Comparable{
    private  final int x;
    private final  int y;


    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Point2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}