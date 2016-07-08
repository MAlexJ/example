package example_01;

/**
 * Created by malex on 08.07.16.
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n0 = 1, n1 = 1, n2;
        System.out.print(0 + " " + n0 + " " + n1 + " ");
        for (int i = 0; i < 45; i++) {
            n2 = n0 + n1;
            System.out.print(n2 + " ");
            n0 = n1;
            n1 = n2;
        }
        System.out.println();
    }
}
