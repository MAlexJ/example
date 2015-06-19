package lecure_01_exeption_syntax.example_08_try_catch;

/**
 * Created by Alex on 19.06.2015.
 */
public class TestTryCatch_02 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) e;
                System.err.print("This is RuntimeException " +re.toString());
            } else {
                System.err.print("В каком смысле не RuntimeException???");
            }
        }
    }

}
