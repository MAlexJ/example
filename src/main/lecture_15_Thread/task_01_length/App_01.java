package task_01_length;

public class App_01 {

    public static final int N = 1_000_000_000;
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread_0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter++;
                }
            }
        });

        thread_0.start();

        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter++;
                }
            }
        });

        thread_1.start();

        thread_0.join();
        thread_1.join();

        System.out.println(counter);

    }
}
