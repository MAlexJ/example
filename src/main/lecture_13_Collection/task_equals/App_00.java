package task_equals;

import java.util.ArrayList;
import java.util.List;

public class App_00 {

    public static void main(String[] args) {
        List<Point2D> list = new ArrayList<>();

        list.add(new Point2D(0, 0));
        System.out.println(list.contains(new Point2D(0, 0)));
        System.out.println(list.remove(new Point2D(0, 0)));

        System.out.println(list);
    }
}
