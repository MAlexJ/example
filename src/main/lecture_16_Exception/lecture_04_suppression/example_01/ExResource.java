package lecture_04_suppression.example_01;

public class ExResource implements AutoCloseable {
    private final String str;

    public ExResource(String str) {
        this.str = str;
    }

    public void calc(int a, int b) {
        System.out.println(a / b);
    }

    @Override
    public void close() {
        //Не удалось закрыть правильно ресурс

        //1
        throw new RuntimeException(str);
    }
}