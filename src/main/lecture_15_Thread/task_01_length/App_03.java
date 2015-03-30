package task_01_length;


// https://ru.wikipedia.org/wiki/%D0%90%D1%82%D0%BE%D0%BC%D0%B0%D1%80%D0%BD%D0%B0%D1%8F_%D0%BE%D0%BF%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D1%8F

public class App_03 {

    public static final int N = 10_000_000;
    public static int counter = 0;

    public static void inc() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread_0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    inc();
                }
            }
        });

        thread_0.start();

        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    inc();
                }
            }
        });

        thread_1.start();

        thread_0.join();
        thread_1.join();

        System.out.println(counter);

    }
}
