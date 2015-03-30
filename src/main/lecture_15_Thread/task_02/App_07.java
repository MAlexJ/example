package task_02;

/**
 * Created by Alex on 19.02.2015.
 */
public class App_07 {
    public static void main(String[] args) throws InterruptedException {

        //Load CPU <= 0%
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println(" Thread.sleep(1000);");
        }

    }
}
