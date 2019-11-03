package com.malex.lecture_15_Concurrency.task_11_common_resource_synchronize_method;

public class App_11_Common_Res_Synch_Method {

    public static void main(String[] args) {
        CommonResource resource = new CommonResource();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyThread(resource), "Thread #" + i);
            thread.start();
        }
    }

}

//Common resource -> synchronize method
class CommonResource {
    private int x;

    synchronized void setX() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + this.x);
            this.x++;
        }
    }
}

class MyThread implements Runnable {

    private CommonResource resource;

    MyThread(CommonResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        this.resource.setX();
    }
}
