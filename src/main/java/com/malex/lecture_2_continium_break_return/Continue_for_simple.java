package com.malex.lecture_2_continium_break_return;

// transition operators.
public class Continue_for_simple {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.print(i+" ");
            if(i%2==0){
                continue;
            }
            System.out.println();
        }
    }
}
