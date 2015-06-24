package lecture_03_exception_java_7.example_02_try_abclass;

public abstract class AutoCloseFile implements AutoCloseable {
    @Override
    public abstract void close() throws Error;
}
