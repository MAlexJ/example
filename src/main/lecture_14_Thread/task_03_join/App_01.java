package task_03_join;

/**
 * Created by Alex on 21.02.2015.
 */
public class App_01 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 6; i++) {
                        Thread.sleep(1000);
                        System.out.println("Hello -> " + Thread.currentThread().getName());
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread_1.start();

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("Bye -> " + Thread.currentThread().getName());
        }

        System.out.println("Thats ALL -> " + Thread.currentThread().getName());


    }
}
