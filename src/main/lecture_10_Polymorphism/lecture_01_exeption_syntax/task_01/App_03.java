package lecture_01_exeption_syntax.task_01;

/**
 * Created by Alex on 24.02.2015.
 */
public class App_03 {

    public static void main(String[] args) {
        A3 a = new B3();
        System.out.println("a.i -> "+a.i);
        System.out.println("a.getI()-> "+ a.getI());
    }

}

class A3 {
    static int i = 3;

    int getI() {
        return i;
    }
}

class B3 extends A3 {
    static int i = 5;

    int getI() {
        return i;
    }
}