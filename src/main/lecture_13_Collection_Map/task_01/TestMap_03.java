package task_01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 20.05.2015.
 */
public class TestMap_03 {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "a");
        map.put(2, "a");
        map.put(3, "a");
        map.put(4, "a");
        map.put(5, "a");
        map.put(6, "a");
        map.put(7, "a");


        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + " " + value);
        }
    }
}
