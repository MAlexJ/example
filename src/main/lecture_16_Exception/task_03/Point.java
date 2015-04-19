package task_03;

/**
 * Created by Alex on 4/18/2015.
 */
public class Point {
    public static final int MAX_X = 1000;
    public static final int MAX_Y = 1000;

    private final int x;
    private final int y;

    public Point(int x, int y) {
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


}
