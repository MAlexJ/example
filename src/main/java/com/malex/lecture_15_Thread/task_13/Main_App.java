package com.malex.lecture_15_Thread.task_13;

public class Main_App {

    public static void main(String[] args) {

        Store store = new Store();
        new Produser(store).start();
        new Consumer(store).start();
    }

}

class Store {
    private int count;
    public static final int MAX_COUNT = 5;

    //int-> error code 1 OR 0
    synchronized int put() {
        while (count <= MAX_COUNT) {
            count++;
            System.out.println("    >>> Store: " + count);
            return 1;
        }
        return 0;
    }

    synchronized int get() {
        while (count > 0) {
            count--;
            System.out.println("    >>> Store: " + count);
            return 1;
        }
        return 0;
    }
}

class Consumer extends Thread {
    private Store store;
    private int product = 0;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (product < Store.MAX_COUNT) {
            product += store.get();
            System.out.println(" << Consumer get product: " + product);
            try {
                sleep(1300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Produser extends Thread {
    private Store store;
    private int product = 5;

    public Produser(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (product > 0) {
            this.product -= store.put();
            System.out.println(" >> Producer create count: " + product);
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
