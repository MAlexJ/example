package example_01_min_element;

public class Solution_3 {
    public static void main(String[] args) {
        System.out.println(minNumber(20, -1, 1, 18));
        System.out.println(minNumber(0, 0, 0, 0));
        System.out.println(minNumber(1, -2, 10, 2));
        System.out.println(minNumber(-5, 2, -1, 5));
        System.out.println(minNumber(5, 2, 10, 5));
    }

    public static int minNumber(int a, int b, int c, int d) {
        if (a < b & a < c & a < d) {
            return a;
        }
        if (b < a & b < c & b < d) {
            return b;
        }
        if (c < a & c < b & c < d) {
            return b;
        }
        return d;
    }
}
