package lecture_05_Thread;

/**
 * Created by root on 27.06.15.
 */
public class TestMain_Thread {


    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("    -> i =" + i + "  " + Thread.currentThread().getName());

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i == 5) {
                        throw new RuntimeException();
                    }

                }
            }
        });

        thread.start();


        for (int j = 0; j < 10; j++) {
            System.out.println("* j =" + j + "  " + Thread.currentThread().getName());
            Thread.sleep(500);
        }


    }

}
