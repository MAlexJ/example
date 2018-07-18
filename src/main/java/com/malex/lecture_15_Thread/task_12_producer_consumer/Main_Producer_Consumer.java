package com.malex.lecture_15_Thread.task_12_producer_consumer;

public class Main_Producer_Consumer {

    public static void main(String[] args) {
        Store store = new Store();
        new Producer(store).start();
        new Consumer(store).start();
    }

}

class Store {
    int counter = 0; // счетчик товаров
    final int N = 5; // максимально допустимое число

    synchronized int put() {
        if (counter <= N)
        {
            counter++; // кладем товар
            System.out.println("склад имеет " + counter + " товар(ов)");
            return 1;
        }
        return 0;
    }

    synchronized int get() {
        if (counter > 0)
        {
            counter--; //берем товар
            System.out.println("склад имеет " + counter + " товар(ов)");
            return 1;
        }
        return 0;
    }
}

class Producer extends Thread {
    Store store;
    int product = 5;

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (product > 0) { //пока у производителя имеются товары
                product = product - store.put(); //кладем один товар на склад
                System.out.println("производителю осталось произвести " + product + " товар(ов)");
                sleep(300); // время простоя
            }
        } catch (InterruptedException e) {
            System.out.println("поток производителя прерван");
        }
    }
}

// поток покупателя
class Consumer extends Thread {
    Store store; //объект склада, с которого покупатель будет брать товар
    int product = 0; //текущее количество товаров со склада

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (product < 5) {// пока количество товаров не будет равно 5

                product = product + store.get(); //берем по одному товару со склада
                System.out.println("Потребитель купил " + product + " товар(ов)");
                sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("поток потребителя прерван");
        }
    }
}
