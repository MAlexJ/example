package example_06_exchange_variable;

/**
 * Created by Alex on 30.05.2015.
 */
public class Task_02_method_exchange {
    public static int a = 7;
    public static int b = 9;

    public static void main(String[] args) {
        swap(a, b);

    }

    public static void swap(int firstNum, int secondNum) {
        System.out.println("firstNum-> " + firstNum + ", secondNum-> " + secondNum);

        System.out.println("Exchange variable");
        int result = firstNum;
        firstNum = secondNum;
        secondNum = result;

        System.out.println("firstNum-> " + firstNum + ", secondNum-> " + secondNum);
    }


}
