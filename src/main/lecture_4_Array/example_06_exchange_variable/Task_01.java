package example_06_exchange_variable;

/**
 * Created by Alex on 30.05.2015.
 */
public class Task_01 {
    public static int a = 10;
    public static int b = 3;

    public static void main(String[] args) {

        System.out.println("input -> a=" + a + ", b=" + b);

        System.out.println(">>>>>>>>  Exchange variable <<<<<<<");

        // variable 'a' - store ram;
        int c = a;
        a = b;
        b = c;

        System.out.println("output -> a=" + a + ", b=" + b);
    }
}
