package com.malex.lecture_13_collection_api.map.class_implementation.hashMap.sample;

import lombok.extern.java.Log;

public interface MapSampleImpl {

    void useDuplicateKey();

    void getValuesInVariousWay();

    void splitKeyAndValues();

    void callingDifferentTypesOfMaps();

    default void print(String val) {
        LogHolder.log(val);
    }

    @Log
    final class LogHolder {

        private LogHolder() {
            // not use
        }

        public static void log(String val) {
            String text = String.format("%s", val);
            log.info(text);
        }
    }
}
