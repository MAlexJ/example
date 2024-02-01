package com.malex.lecture_13_collection_api.task_equals;

/**
 * Created by Alex on 2/17/2015.
 */
public class Point2D_equals {
    public final int x;
    public final int y;


    public Point2D_equals(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Point2D_equals that = (Point2D_equals) obj;

        return this.x == that.x && this.y == that.y;
    }


}
