package example_02_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ES_Main
{
    public static void main(String[] args)
    {
        // #1
        Runnable runnable = () ->
        {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        // #2
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(runnable);

        // #3 close executor
        try
        {
            System.out.println("Attempt to shutdown executor !");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException ex)
        {
            System.out.println("Tasks interrupted !");
        } finally
        {
            if (!executor.isTerminated())
            {
                System.out.println("Cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println(">>> Shutdown finished");
        }
    }
}
