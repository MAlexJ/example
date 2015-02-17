package task_equals;

import java.util.ArrayList;
import java.util.List;


public class App_01 {
    public static void main(String[] args) {

        List<Point2D_Eql_Hash> list = new ArrayList<>();

        list.add(new Point2D_Eql_Hash(0, 0));
        System.out.println(list.contains(new Point2D_Eql_Hash(0, 0)));
        System.out.println(list.remove(new Point2D_Eql_Hash(0, 0)));

        System.out.println(list);


    }
}
