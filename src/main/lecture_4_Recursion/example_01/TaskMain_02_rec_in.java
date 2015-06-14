package example_01;

public class TaskMain_02_rec_in {

    public static void main(String[] args) {
        f(1);
    }

    public static void f(int arg) {
        System.out.print(" " + arg);
        if (arg < 7) {
            f(2 * arg);
        }
    }

}
