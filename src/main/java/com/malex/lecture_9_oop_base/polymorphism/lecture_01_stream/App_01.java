package com.malex.lecture_9_oop_base.polymorphism.lecture_01_stream;

/**
 * Итак, в java все нестатические неприватные (то есть, protected, package и public) методы являются виртуальными.
 * Ключевое слово final запрещает возможность дальнейшего переопределения метода в подклассах
 * <p>
 * Вопрос: что выведет данный код?
 */
public class App_01 {
    public static void main(String[] args) {
        A a = new B();
        System.out.println("a.i -> " + a.i);
        System.out.println("a.getI()-> " + a.getI());
    }
}


class A {
    //field
    int i = 3;
    //method
    int getI() {
        return i;
    }
}


class B extends A {
    int i = 5;

    int getI() {
        return i;
    }
}











/**Ответ:
 1. Так как поля класса не наследуются, то у класса A своё поле i и у класса B тоже своё поле i.
 Так как для полей полиморфизм не действует, то при обращении a.i мы обращаемся к классу A,
 поэтому на экран будет выведено 3.

 2. При вызове метода a.getI() у нас в дело вступает полиморфизм,
 поэтому будет вызван метод от класса, инстанс которого был создан. Соответственно, мы получим на выходе 5.*/