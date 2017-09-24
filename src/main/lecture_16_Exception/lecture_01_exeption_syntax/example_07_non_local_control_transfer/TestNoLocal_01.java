package lecture_01_exeption_syntax.example_07_non_local_control_transfer;

public class TestNoLocal_01 {
    public static void main(String[] args) {

        System.err.println("#1.in");
        f(); //
        System.err.println("#1.out");
    }

    public static void f() {
        System.err.println(".   #2.in");
        g();
        System.err.println(".   #2.out");
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h();
        System.err.println(".   .   #3.out");
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.RETURN");
            return;
        }
        System.err.println(".   .   .   #4.out");


    }
}
