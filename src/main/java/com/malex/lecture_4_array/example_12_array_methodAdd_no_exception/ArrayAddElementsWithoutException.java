package com.malex.lecture_4_array.example_12_array_methodAdd_no_exception;

import java.util.Arrays;

public class ArrayAddElementsWithoutException {

    private int[] array;
    private int next;

    private ArrayAddElementsWithoutException(int size) {
        this.array = new int[size];
    }

    public void add(int num) {
        if (next < array.length) {
            array[next++] = num;
        }
    }

    public void print() {
        System.out.println(Arrays.toString(this.array));
    }

    public static void main(String[] args) {
        ArrayAddElementsWithoutException obj = new ArrayAddElementsWithoutException(4);
        obj.add(5);
        obj.add(5);
        obj.add(5);
        obj.add(5);
        obj.add(5);
        obj.add(5);
        obj.print();
    }
}
