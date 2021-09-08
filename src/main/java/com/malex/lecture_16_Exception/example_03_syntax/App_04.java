package com.malex.lecture_16_Exception.example_03_syntax;

/**
 * Created by Alex on 19.02.2015.
 */
public class App_04 {
    public static void main(String[] args) {
        Runnable r = new RunnableImpl();

        // -> public Thread(Runnable target)
        Thread newThread = new Thread(r);
        //Causes this thread to begin execution; the Java Virtual Machine
        // calls the run method of this thread.
        newThread.start();
    }

}
