package example_01_simple;

public class TE_Main_01
{
    public static void main(String[] args)
    {
        Runnable task = () ->
        {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        // #1
        task.run();

        // #2
        new Thread(task).start();

        // #3
        System.out.println("Done!");
    }
}
