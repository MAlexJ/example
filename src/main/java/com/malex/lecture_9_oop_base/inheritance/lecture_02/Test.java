package com.malex.lecture_9_oop_base.inheritance.lecture_02;

/**
 * Created by malex on 14.06.16.
 */
public class Test {
    class A {
        private String str = "ab";
        public A() {
            printLength();
        }

        void printLength(){
            System.out.println(str.length());
        }
    }

    class B extends A{
        private String str = "abs";
// TODO open comment -> EXCEPTION ->NPE
//        void printLength(){
//            System.out.println(str.length());
//        }
    }

    public static void main(String[] args) {
        new Test().new B();
    }
}
