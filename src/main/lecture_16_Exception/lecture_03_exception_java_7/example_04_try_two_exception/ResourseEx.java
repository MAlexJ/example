package lecture_03_exception_java_7.example_04_try_two_exception;

public class ResourseEx implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("close: " + getClass().getSimpleName());
    }
}
