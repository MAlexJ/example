package lecture_03_exception_java_7.example_02_try_abclass;

public class ResourceFile extends AutoCloseFile {
    @Override
    public void close() throws Error {
        System.out.println("close: " + getClass().getSimpleName());
    }
}
