package com.malex.lecture_9_oop_base.polymorphism.task_polimorph_overload_method;

class A {
    void m1(A a) {
        System.out.print("A");
    }
}

class B extends A {
    // Overload mehod
    void m1(B b) {
        System.out.print("B");
    }
}

class C extends B {
    // @Override
    void m1(B c) {
        System.out.print("C");
    }
}

 class D {
    public static void main(String[] args) {
        A c1 = new C();
        c1.m1(new B());
    }
}
