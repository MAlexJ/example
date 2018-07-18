package com.malex.lecture_15_Thread.task_09_common_resource;

public class App_09_Common_Res {

    public static void main(String[] args) {

        CommonResource commonResource = new CommonResource();

        for (int i=0;i<4;i++){
            Thread thread = new Thread(new MyThread(commonResource),"Поток:");
            thread.start();
        }
    }

}

//Common object
class CommonResource {
    int x = 0;
}

//My thread
class MyThread implements Runnable {

    private CommonResource common;

    public MyThread(CommonResource common) {
        this.common = common;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + common.x++);
        }
    }
}
