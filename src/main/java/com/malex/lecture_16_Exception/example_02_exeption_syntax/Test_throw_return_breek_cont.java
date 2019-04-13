package com.malex.lecture_16_Exception.example_02_exeption_syntax;

/**
 * Created by Alex on 19.06.2015.
 */
public class Test_throw_return_breek_cont {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {

            f();
            System.out.println();
        }
    }

    public static void f() {
        for (int k = 0; k < 2; k++) {
            System.out.print(0);
            //  if (true) continue;
            //  if (true) break;
            //  if (true) return;
            //  if (true) throw new RuntimeException();
            System.out.print(1);
        }
        System.out.print(2);
    }
}
