package example_01_min_element;
import java.util.Arrays;

public class Solution_1 {
    public static void main(String[] args) {
        System.out.println(minNumber(20, -1, 1, 18));
        System.out.println(minNumber(0, 0, 0, 0));
        System.out.println(minNumber(1, -2, 10, 2));
        System.out.println(minNumber(-5, 2, -1, 5));
        System.out.println(minNumber(5, 2, 10, 5));
    }

    public static int minNumber(int a, int b, int c, int d) {
       int [] arr = {a,b,c,d};
        Arrays.sort(arr);
        return arr[0];
    }

}
