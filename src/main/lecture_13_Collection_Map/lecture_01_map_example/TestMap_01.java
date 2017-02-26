package lecture_01_map_example;


import java.util.HashMap;
import java.util.Map;

/**
 * Map - An object that maps keys to values.
 * A map cannot contain duplicate keys
 * each key can map to at most one value.
 */
public class TestMap_01 {

    public static void main(String[] args) {

        Map<String, String> mapStr = new HashMap<>();

        mapStr.put("1", "asd");
        mapStr.put("1", "ewq");

        System.out.println(mapStr);
    }

}
