package example_01;

/**
 * Created by Alex on 14.06.2015.
 */
public class Test_1_2 {
    public static void main(String[] args) {
        System.out.println(f(5, 3));
    }

    public static int f(int a, int b) {
        System.out.println(a + " " + b);
        return (b == 0) ? a : 1 + f(a, b - 1);
    }
}
