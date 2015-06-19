package lecure_01_exeption_syntax.task_01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 20.05.2015.
 */
public class TestMap_04 {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("1", "a");
        map.put("2", "a");
        map.put("3", "a");
        map.put("4", "a");
        map.put("5", "a");
        map.put("6", "a");
        map.put("7", "a");


        // Entry ->>>  entry.setValue("xxxxx");
        for(Map.Entry<String, String> entry: map.entrySet()){

            if("4".equals(entry.getKey())){
                entry.setValue("xxxxx");

            }
        }
        System.out.println(map);


        // Entry ->>>  entry.setValue("yyyyyy");
//        for(Map.Entry<String, String> entry: map.entrySet()){
//
//            if("a".equals(entry.getValue())){
//                entry.setValue("yyyyyy");
//
//            }
//        }
//        System.out.println(map);

    }

}
