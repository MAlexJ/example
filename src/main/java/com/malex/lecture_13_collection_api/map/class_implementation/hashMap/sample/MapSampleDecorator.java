package com.malex.lecture_13_collection_api.map.class_implementation.hashMap.sample;

public class MapSampleDecorator implements MapSampleImpl {
    private static final String END_MSG = "#END\n";

    // Holder class
    private MapSample sample;

    public MapSampleDecorator(MapSample sample) {
        this.sample = sample;
    }

    @Override
    public void useDuplicateKey() {
        print("#1 put duplicate key");
        sample.useDuplicateKey();
        print(END_MSG);
    }

    @Override
    public void getValuesInVariousWay() {
        print("#2 get values of map in various way");
        sample.getValuesInVariousWay();
        print(END_MSG);
    }

    @Override
    public void splitKeyAndValues() {
        print("#3 split key and values");
        sample.splitKeyAndValues();
        print(END_MSG);
    }

    @Override
    public void callingDifferentTypesOfMaps() {
        print("#4 calling different types of maps with NULL");
        sample.callingDifferentTypesOfMaps();
        print(END_MSG);
    }
}
