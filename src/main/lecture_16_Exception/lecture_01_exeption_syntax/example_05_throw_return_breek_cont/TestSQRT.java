package lecture_01_exeption_syntax.example_05_throw_return_breek_cont;


public class TestSQRT {
    public static void main(String[] args) {
        System.out.println(sqr(2));
    }

    public static double sqr(double arg) { // надо double
        return arg * arg;           // double * double - это double
    }

}
