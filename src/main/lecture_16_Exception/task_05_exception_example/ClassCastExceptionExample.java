package task_05_exception_example;

/**
 * Created by Alex on 4/18/2015.
 */
public class ClassCastExceptionExample {
    public static void main(String[] args) {
        Object ref = new int[1];
        String str = (String) ref;
        //        int[] intArr = (int[]) ref;
    }
}
