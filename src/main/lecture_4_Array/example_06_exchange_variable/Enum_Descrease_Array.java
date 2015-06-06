package example_06_exchange_variable;

/**
 * Created by Alex on 30.05.2015.
 */
public class Enum_Descrease_Array {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = array.length - 1; i > 1; i--)
            System.out.print(array[i] + " ");

    }
}
