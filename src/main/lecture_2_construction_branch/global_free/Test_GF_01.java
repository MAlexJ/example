package global_free;

/**
 * @author malex
 */

public class Test_GF_01 {

    public static void main(String[] args) {

        // task 1
        binaryOperation();

        // task 2
        divOperation();
    }

    // task 1
    private static void binaryOperation() {
        int x = 11 & 9;

        System.out.println("X: " + x);
        int y = x ^ 3;

        System.out.println("y: " + y);
        System.out.print("Result task 1: ");
        System.out.println(y | 12);
    }

    // task 2
    private static void divOperation() {
        int numerator = 17;
        int denominator = 5;
        double result = (double) numerator / denominator;
        System.out.println("Result task 2: " + result);
    }

}
