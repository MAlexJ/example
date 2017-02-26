package lecture_01_map_example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author malex
 */
public class TestMap_02 {

    public static void main(String[] args) {

        Map<Integer, String> mapStr = new HashMap<>();
        mapStr.put(1, "asd");
        mapStr.put(2, "ewq");
        mapStr.put(5, "ewq");
        mapStr.put(3, "ewq");
        mapStr.put(4, "ewq");

        // Print Map<K,V>
        System.out.println("MAP: " + mapStr + "\n");

        // Set KEYS (keySet)
        Set<Integer> integerSet = mapStr.keySet();
        System.out.println(" Set<Integer> integerSet = mapStr.keySet(); \n " + integerSet + "\n");

        // Values (values);
        Collection<String> stringCollection = mapStr.values();
        System.out.println(" Collection<String> stringCollection = mapStr.values(); \n " + stringCollection + "\n");

        // Values and Key (Map.Entry entrySet).
        Set<Map.Entry<Integer, String>> entries = mapStr.entrySet();
        System.out.println(" Set<Map.Entry<Integer, String>> entries = mapStr.entrySet(); \n " + entries + "\n");

    }
}
