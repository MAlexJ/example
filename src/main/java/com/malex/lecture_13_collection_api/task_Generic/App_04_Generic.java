package com.malex.lecture_13_collection_api.task_Generic;

import lombok.extern.java.Log;

/**
 * Created by Alex on 04.02.2015.
 */
@Log
public class App_04_Generic {

    public static void main(String[] args) {
        WithVersion<String> strV = new WithVersion<>("Mike", 10);

        WithVersion<int[]> intArraV = new WithVersion<>(new int[]{1, 5, 3}, 10);

        //???????????????
        new WithVersion<>();

        log.info("main");
        log.info(strV.toString());
        log.info(intArraV.toString());

    }
}

// T - type variable
//Generic work only with object. No primitive variable
class WithVersion<T> {
    private T value;
    private int version;

    public WithVersion() {
    }

    public WithVersion(T value, int version) {
        this.value = value;
        this.version = version;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "task_Generic.WithVersion{" +
                "value=" + value +
                ", version=" + version +
                '}';
    }
}
