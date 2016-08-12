package lecture_01_stream;

/**
 * Created by Alex on 24.02.2015.
 */
public class App_04 {

    public static void main(String[] args) {

        A4 a = new B4();
        System.out.println("a.i -> "+a.i);
        System.out.println("a.getI()-> "+ a.getI());
    }
}


class A4 {
    static int i = 3;

   int getI() {
        return i;
    }
}

class B4 extends A4 {
     int i = 5;

     int getI() {
        return i;
    }
}