package com.malex.lecture_13_collection_api.list.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackVsList
{

    private static final int ARRAY[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args)
    {

        // #1 use of the Stack
        List<Integer> listStack = new Stack<>();
        for (int aARRAY : ARRAY)
        {
            listStack.add(aARRAY);
        }

        // #2 use of the ArrayList
        List<Integer> listArrayList = new ArrayList<>();
        for (int aARRAY : ARRAY)
        {
            listArrayList.add(aARRAY);
        }

        // #3 use of the LinkedList
        List<Integer> LinkedList = new LinkedList<>();
        for (int aARRAY : ARRAY)
        {
            LinkedList.add(aARRAY);
        }

        // print result
        System.out.println("List listStack = new Stack() >>> " + listStack);
        System.out.println("Position elem in Stack: 9 8 7 6 5 4 3 2 1 ");
        System.out.println();
        System.out.println("List listArrayList = new ArrayList(Arrays.asList(arr)) >>> " + listArrayList);
        System.out.println("Position elem in ArrayList: 0 1 2 3 4 5 6 7 8");
        System.out.println();
        System.out.println("List LinkedList = new LinkedList(Arrays.asList(arr)) >>> " + LinkedList);
        System.out.println("Position elem in LinkedList: 0 1 2 3 4 5 6 7 8 ");
        System.out.println();
    }
}
