package com.malex.lecture_2_statements.ControlStatements.flow_control_statements;

public class ContinueWithLabel {

    public static void main(String[] args) {

        System.out.println("````````````````````````````````````````");
        th:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println("+");
                    continue th;
                }
                System.out.print(j);
            }
        }

        System.out.println();
        System.out.println("````````````````````````````````````````");
        th:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j < i) {
                    System.out.println("+");
                    continue th;
                }
                System.out.print(j);
            }
        }
    }
}
