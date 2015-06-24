package lecture_01_exeption_syntax.example_08_try_catch;

public class TestTryCatch_01 {

    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");

            // catch по Exception перехватывает И RuntimeException
        } catch (Exception e) {
            System.err.print(" 2"); // сюда заходим
        }
        System.err.println(" 3");
    }


}
