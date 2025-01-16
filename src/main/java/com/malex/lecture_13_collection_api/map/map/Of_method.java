package com.malex.lecture_13_collection_api.map.map;

import java.util.Map;

import org.junit.Test;

public class Of_method {

    /*
    * Returns an unmodifiable map containing zero mappings.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void of_empty_method() {
        Map<Object, Object>  unmodifiableMap = Map.of();

        // Immutable object is modified  - > UnsupportedOperationException
        unmodifiableMap.put(new Object(), "value");
    }
}
