package com.malex.lecture_13_collection_api.task_Collection;

import java.util.Set;
import java.util.TreeSet;

public class App_08_TreeSet {
    public static void main(String[] args) {
        Set<Point22> set = new TreeSet<>();
        set.add(new Point22(1, 1));
        set.add(new Point22(2, 1));
        set.add(new Point22(4, 3));
        System.out.println(set);
        System.out.println(set.contains(new Point22(2, 1)));
    }
}

class Point22 implements Comparable {
    private final int x;
    private final int y;

    Point22(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point22{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Point22 point = (Point22) o;
        if (this.x < point.x) {
            return -1;
        }
        if (this.x > point.x) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point22 point22 = (Point22) o;
        if (x != point22.x) return false;
        return y == point22.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
