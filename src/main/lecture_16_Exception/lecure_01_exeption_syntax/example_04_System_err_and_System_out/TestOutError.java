package lecure_01_exeption_syntax.example_04_System_err_and_System_out;

public class TestOutError {
    public static void main(String[] args) {
        System.out.println("sout");
        throw new Error();
    }
}
