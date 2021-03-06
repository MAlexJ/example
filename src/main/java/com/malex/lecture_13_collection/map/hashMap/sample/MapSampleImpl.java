package com.malex.lecture_13_collection.map.hashMap.sample;

import lombok.extern.log4j.Log4j;

public interface MapSampleImpl {

    void useDuplicateKey();

    void getValuesInVariousWay();

    void splitKeyAndValues();

    void callingDifferentTypesOfMaps();

    default void print(String val) {
        LogHolder.log(val);
    }

    @Log4j
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
