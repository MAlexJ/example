package example_01;

import java.util.Stack;

public class MyStack {

    public static void main(String[] args) {

        Stack stack = new Stack();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println();
        while (!stack.isEmpty()) {
            System.out.print(" " + stack.pop());
        }

    }

}
