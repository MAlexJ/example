package com.malex.lecture_13_collection_api.task_Collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Alex on 2/17/2015.
 */
public class App_06_TreeSet {

    //???
    public static void main(String[] args) {
        Set<Point> set = new TreeSet<>();
        set.add(new Point(1,1));
    }
}

class Point{
    private  final int x;
    private  final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
