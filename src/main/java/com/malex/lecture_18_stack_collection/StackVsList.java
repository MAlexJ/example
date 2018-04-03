package com.malex.lecture_18_stack_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackVsList {

    private static int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {

        //********   1   *********
        List listStack = new Stack();

        for (int i = 0; i < arr.length; i++) {
            listStack.add(arr[i]);
        }
        List listArrayList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            listArrayList.add(arr[i]);
        }

        List LinkedList = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            LinkedList.add(arr[i]);
        }
        System.out.println("List listStack = new Stack() >>>" + listStack);
        System.out.println("Position elem Stack: 9 8 7 6 5 4 3 2 1 ");
        System.out.println();
        System.out.println("List listArrayList = new ArrayList(Arrays.asList(arr)) >>>" + listArrayList);
        System.out.println("Position elem Stack: 0 1 2 3 4 5 6 7 8");
        System.out.println();
        System.out.println("List LinkedList = new LinkedList(Arrays.asList(arr)) >>>" + LinkedList);
        System.out.println("Position elem Stack: 0 1 2 3 4 5 6 7 8 ");
        System.out.println();
    }
}
