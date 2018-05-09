package com.malex.lecture_18_stack_collection;

import java.util.Stack;

public class StackPopExample
{
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        for (int anArr : arr)
        {
            stack.push(anArr);
        }

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println();
        while (!stack.isEmpty())
        {
            System.out.print(" " + stack.pop());
        }
    }
}
