package lecture_01_map_example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author malex
 */
public class TestMap_05 {

    public static void main(String[] args) {

        Map<String, String> mapLinkedHash = new LinkedHashMap<>();

        Map<String, String> mapLHash = new HashMap<>();

        Map<String, String> mapTree = new TreeMap<>();

        // #1 *****   null -> key ************
        mapLinkedHash.put(null, "A");
        mapLHash.put(null, "A");

        //  >>>>   NullPointerException
        try {
            mapTree.put(null, "A");
        } catch (NullPointerException ex) {
            // ignore
        }

        System.out.println(" #1: Set KEY 'null' to Map<K,V>");
        System.out.println("1. LinkedHashMap: " + mapLinkedHash);
        System.out.println("2. HashMap: " + mapLHash);
        System.out.println("3. If set KEY 'null' to Tree map when expect throw new NPE!  " + mapTree + "\n");


        // #2 ********** null -> value ***********
        mapLinkedHash.put("A", null);
        mapLHash.put("S", null);
        mapTree.put("D", null);

        System.out.println(" #2: Set VALUE 'null' to Map<K,V>");
        System.out.println("1. LinkedHashMap: " + mapLinkedHash);
        System.out.println("2. HashMap: " + mapLHash);
        System.out.println("3. TreeMap: " + mapTree);


    }

}
