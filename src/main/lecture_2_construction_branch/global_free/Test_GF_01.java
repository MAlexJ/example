package global_free;

/**
 * @author malex
 */

public class Test_GF_01 {

    public static void main(String[] args) {
        int x = 11 & 9;
        System.out.println("X: " + x);
        int y = x ^ 3;
        System.out.println("y: " + y);
        System.out.print("Result: ");
        System.out.println(y | 12);
    }

}
