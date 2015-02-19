package task_01;

/**
 * Created by Alex on 19.02.2015.
 */
public class App_04 {
    public static final int N = 10_000_000;
    public static int counter = 0;

    //add -> synchronized
    public synchronized static void inc() {
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
