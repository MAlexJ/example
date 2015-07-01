package example_01;


import java.util.Stack;


public class Main {

    private static int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("stack.empty() -> " + stack.empty());

        for (int i = 0; i < arr.length; i++)
            stack.push(arr[i]);

        System.out.println("stack.empty() -> " + stack.empty());

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());


        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack);

        System.out.println("stack.search(1) -> " + stack.search(1));
        System.out.println("stack.search(5) -> " + stack.search(5));

    }
}
