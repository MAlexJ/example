package lecture_05_Thread;

/**
 * Created by root on 27.06.15.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {


        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<10;i++){
                    System.out.println(" ->>>> j= " + i +" " +Thread.currentThread().getName());
                    if(i==5){ throw  new RuntimeException(); }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread0.start();


        for (int i = 0;i<10;i++){
            System.out.println(" * i= " + i +" " +Thread.currentThread().getName());
            Thread.sleep(500);
        }
        System.out.println("Exit main");

    }

}
