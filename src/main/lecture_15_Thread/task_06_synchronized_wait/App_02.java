package task_06_synchronized_wait;

/**
 * Created by Alex on 02.03.2015.
 */
public class App_02 {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printText(1);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printText(2);
            }
        });

        thread1.start();
        thread2.start();

    }


    public synchronized static void printText(int id) {

        System.out.println(id + " im here");
        while (true) {
        }

    }
}
