package lecture_03_exception_java_7.example_02_try_abclass;

public class TestResourceFile {

    public static void main(String[] args) {

        ResourceFile resourceFile1 = new ResourceFile();
        resourceFile1.close();

        try (ResourceFile resourceFile = new ResourceFile()) {
            System.out.println("try");

        }
    }

}
