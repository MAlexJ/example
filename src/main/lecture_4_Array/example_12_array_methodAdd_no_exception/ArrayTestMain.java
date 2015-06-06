package example_12_array_methodAdd_no_exception;

import java.util.Arrays;

public class ArrayTestMain {

    private int[] array;
    private int next;

    public ArrayTestMain(int size) {
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
        ArrayTestMain arrayTestMain = new ArrayTestMain(4);
        arrayTestMain.add(5);
        arrayTestMain.add(5);
        arrayTestMain.add(5);
        arrayTestMain.add(5);
        arrayTestMain.add(5);
        arrayTestMain.add(5);
        arrayTestMain.print();

    }
}
