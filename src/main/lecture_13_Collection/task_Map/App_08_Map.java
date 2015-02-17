package task_Map;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 12.02.2015.
 */
public class App_08_Map {
    private final static Logger LOG = Logger.getLogger(App_08_Map.class);

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        if (LOG.isDebugEnabled()) {
            LOG.debug("map.size() -> " + map.size());
            LOG.debug("map.isEmpty() -> " + map.isEmpty());

            /*    put(K,V);
            * return the previous value associated with key, or  null if there was no mapping for key.
            * A null return can also indicate that the map  previously associated null with key,  if the implementation supports null values.)
            * */
            LOG.debug(" map.put(\"Килька\", 25) -> " + map.put("Килька", 25));
            LOG.debug(" map.put(\"Килька\", 31) -> " + map.put("Килька", 31));
            LOG.debug(" map.put(\"Силька\", 10) -> " + map.put("Сардина", 10));

            // containsKey(K)
            LOG.debug(" map.containsKey(\"Килька\") -> " + map.containsKey("Килька"));

            // containsValue(V)
            LOG.debug("  map.containsValue(25) -> " + map.containsValue(25));

            //size()
            LOG.debug("map.size() -> " + map.size());

            //remove(K)
            /* return the previous value associated with key, or null if there was no mapping for key*/
            LOG.debug(" map.remove(\"Килька\") -> " + map.remove("Килька"));

            //remove(K, V);
            LOG.debug(" map.remove(\"Сардина\", 10) -> " + map.remove("Сардина", 10));

            //size()
            LOG.debug("map.size() -> " + map.size());

            //map.put(null,12)
            LOG.debug("map.put(null,12) -> " + map.put(null,12));
            LOG.debug("map.put(null,12) -> " + map.put(null,12));

            //size()
            LOG.debug("map.size() -> " + map.size());

            //map.put("null",12)
            LOG.debug("map.put(null,12) -> " + map.put("null",null));

            //size()
            LOG.debug("map.size() -> " + map.size());

        }


    }

}
