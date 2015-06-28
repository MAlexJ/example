package lecture_03_exception_java_7.example_01_try;


public class Resource implements AutoCloseable {


    @Override
    public void close() throws Exception {
        System.out.println("close()");
    }
}
