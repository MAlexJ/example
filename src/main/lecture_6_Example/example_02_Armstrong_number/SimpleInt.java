package example_02_Armstrong_number;

/**
 * Created by Alex on 3/24/2015.
 */
public class SimpleInt {

    public static void main(String[] args) {
        int i = 2, num;
        num = 6;
        int j = 1;
        for (; j < 6; ) {
            num = i + 4;
            j++;
        }
        System.out.println("i = " + i + ",  num = " + num);
    }
}
