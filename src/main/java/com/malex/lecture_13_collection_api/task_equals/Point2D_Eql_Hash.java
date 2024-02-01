package com.malex.lecture_13_collection_api.task_equals;

public class Point2D_Eql_Hash {
    public final int y;
    public final int x;

    public Point2D_Eql_Hash(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Point2D_Eql_Hash that = (Point2D_Eql_Hash) obj;

        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        int result = y;
        result = 31 * result + x;
        return result;
    }

    @Override
    public String toString() {
        return "Point2D_Eql_Hash{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}
