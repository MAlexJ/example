package com.malex.lecture_16_Exception.example_02_exeption_syntax;

import org.junit.Test;

import static junit.framework.TestCase.fail;

/**
 * Created by Alex on 4/18/2015.
 */
public class Point {

    private static final int MAX_X = 1000;
    private static final int MAX_Y = 1000;

    private final int x;
    private final int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    private Point(int x, int y) {
        if (x < 0 || MAX_X < x || y < 0 || MAX_Y < y) {
            throw new IllegalArgumentException("'x' and 'y' must be in ranges [0, " + MAX_X + "] and [0, " + MAX_Y + "] but x = " + x + ", y = " + y);
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Test
    public void test() {
        try {
            new Point(1280, 720);
            fail();
        } catch (Exception e) {
            // none
        }
    }

}
