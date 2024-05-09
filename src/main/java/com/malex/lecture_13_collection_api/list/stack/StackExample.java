package com.malex.lecture_13_collection_api.list.stack;

import java.util.Stack;

public class StackExample
{
    private static final int ARRAY[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args)
    {
        // #1 create Stack
        Stack<Integer> stack = new Stack<>();

        // #2 add values into Stack
        System.out.println("stack.empty() -> " + stack.empty());
        for (int anArr : ARRAY)
        {
            stack.push(anArr);
        }
        System.out.println("stack.empty() -> " + stack.empty());

        // #3 peek() some values
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        // #4 pop() same values
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // #5 print() the Stack
        System.out.println(stack);

        // #6 search() some values
        System.out.println("stack.search(1) -> " + stack.search(1));
        System.out.println("stack.search(5) -> " + stack.search(5));
    }
}
