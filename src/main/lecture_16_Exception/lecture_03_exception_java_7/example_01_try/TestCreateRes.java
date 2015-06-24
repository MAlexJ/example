package lecture_03_exception_java_7.example_01_try;


public class TestCreateRes {

    public static void main(String[] args) {
        try (Resource resource = new Resource()) {
            System.err.println("body");
        }
    }

}
