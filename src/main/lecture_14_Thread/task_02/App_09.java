package task_02;

/**
 * Created by Alex on 19.02.2015.
 */
public class App_09 {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            sillyWork();
            //System.out.print(Thread.currentThread().getName());
            System.out.println("Bye");
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    sillyWork();
                    //System.out.print(Thread.currentThread().getName());
                    System.out.println("Hello");
                }
            }
        }).start();


    }

    //Load CPU <= 100%
    private static void sillyWork() {
        double d = 2.0;
        for (int i = 0; i < 10_000_000; i++) {
            d = Math.sin(d);
        }
    }
}
