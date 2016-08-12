package lecture_01_stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Alex on 20.05.2015.
 */
public class TestMap_05 {

    public static void main(String[] args) {

        Map<String, String> mapLinkedHash = new LinkedHashMap<>();

        Map<String, String> mapLHash = new HashMap<>();

        Map<String, String> mapTree = new TreeMap<>();

       //null -> key
        mapLinkedHash.put(null,"A");
        mapLHash.put(null,"A");

    //  >>>>   NullPointerException
//        mapTree.put(null,"A");

        System.out.println(mapLinkedHash);
        System.out.println(mapLHash);
        System.out.println(mapTree);


        // null -> value
        mapLinkedHash.put("A", null);
        mapLHash.put("S", null);
        mapTree.put("D", null);

        System.out.println(mapLinkedHash);
        System.out.println(mapLHash);
        System.out.println(mapTree);



    }

}
