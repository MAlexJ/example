package lecture_06_exception_example;

/**
 * Created by Alex on 4/18/2015.
 */
public class ArrayStoreExceptionExample {

    public static void main(String[] args) {
        Object[] ref = new Integer[1];
        ref[0] = "Hello!";
    }
}
