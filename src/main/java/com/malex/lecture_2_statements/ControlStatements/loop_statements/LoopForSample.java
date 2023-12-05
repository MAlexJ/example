package com.malex.lecture_2_statements.ControlStatements.loop_statements;

public class LoopForSample {

    public static void main(String[] args) {

        // 1. for
        System.out.println("1. for ");
        boolean flag = true;
        int num = 0;

        for (; flag; ) {
            System.out.print("num :" + num + ", ");
            if (num > 10) {
                flag = false;
                System.out.println("\n");
            }
            num++;
        }

        // 2. for -> two variable
        System.out.println("2. for ");
        int a, b;
        for (a = 1, b = 4; a < b; a++, b--) {
            System.out.println("a= " + a);
            System.out.println("b= " + b);
        }


    }
}
