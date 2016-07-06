package task_08_intterupt_thread_flag;

public class App_08_Interrupt {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();

        Thread thread = new Thread(myThread);

        thread.start();

        Thread.sleep(1000);

        myThread.disable();

    }
}

class MyThread implements Runnable {

    private boolean isAlive;

    MyThread() {
        this.isAlive = true;
    }

    void disable() {
        this.isAlive = false;
    }

    @Override
    public void run() {
        int count = 1;
        while (isAlive) {
            System.out.println(count++);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
