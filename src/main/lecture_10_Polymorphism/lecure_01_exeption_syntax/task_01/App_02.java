package lecure_01_exeption_syntax.task_01;

/**
 * Статические поля и методы виртуальными не являются, поэтому оба вызова выведут нам 3.
 */
public class App_02 {
    public static void main(String[] args) {
        A1 a = new B1();
        System.out.println("a.i -> "+a.i);
        System.out.println("a.getI()-> "+ a.getI());
    }
}

class A1 {
    static int i = 3;

    static int getI() {
        return i;
    }
}

class B1 extends A1 {
    static int i = 5;

    static int getI() {
        return i;
    }
}