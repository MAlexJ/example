package task_02;

public class App_01 {

    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        runnable.run();
    }
}

class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("run()");
    }
}