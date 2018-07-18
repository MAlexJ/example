package com.malex.lecture_15_Thread.task_10_common_resource_synchronize_section;

public class App_10_Common_Res_Synchronize {

    public static void main(String[] args) {
        CommonResource resource = new CommonResource();

        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new MyThread(resource), "Поток #" + i);
            thread.start();
        }
    }
}

//Common resource
class CommonResource {
    private int x;

    int getX() {
        return x;
    }

    void setX() {
        this.x++;
    }
}

//Thread -> synchronize block
class MyThread implements Runnable {

    private final CommonResource resource;

    MyThread(CommonResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (resource) {
            for (int i = 0; i < 5; i++) {
                System.out.println(" " + Thread.currentThread().getName() + " : " + this.resource.getX());
                this.resource.setX();
            }
        }
    }
}
