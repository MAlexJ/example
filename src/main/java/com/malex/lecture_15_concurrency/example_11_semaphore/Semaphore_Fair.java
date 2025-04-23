package com.malex.lecture_15_concurrency.example_11_semaphore;

import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import org.junit.Test;

/*
 * Fair Semaphore (FIFO Order)
 * A fair semaphore ensures that permits are granted in the order they were requested (FIFO).
 */
public class Semaphore_Fair extends AbstractUtils {

  private final ConcurrentLinkedQueue<String> queue;

  private final Semaphore semaphore;

  /*
   * fair – true
   * if this semaphore will guarantee first-in first-out granting of permits under contention, else
   */
  public Semaphore_Fair() {
    semaphore = new Semaphore(1, true); // fair – true
    queue = new ConcurrentLinkedQueue<>();
  }



  public static void main(String[] args) {
    String json = "[{\"date\":1742071798449,\"newBox\":{\"width\":1,\"height\":1,\"length\":0.1,\"position\":[0,0.55,0],\"colorIndex\":3},\"type\":\"START_GAME\"},{\"date\":1742071798502,\"type\":\"MOVING_BOX\",\"box\":{\"position\":[0,0.55,0],\"speed\":0.81,\"distance\":0.9977253925752759}},{\"date\":1742071799776,\"particle\":{\"length\":0.1,\"width\":0.47774460742472336,\"height\":0.3888961663275895,\"position\":[0.7788806958758212,0.9500100000000002,-0.30555191683620525],\"colorIndex\":6},\"type\":\"GAME_OVER\"}]";

    // Регулярное выражение для поиска объекта "GAME_OVER"
    String regex = "\\{\"date\":\\d+,\"particle\":\\{(?:[^{}]*|\\{[^{}]*\\})*?\\},\"type\":\"GAME_OVER\"\\}";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(json);

    if (matcher.find()) {
      System.out.println(matcher.group()); // Выведет объект "GAME_OVER"
    } else {
      System.out.println("Объект 'GAME_OVER' не найден!");
    }
  }




  @Test
  public void fair() {
    try (ExecutorService executorService = Executors.newFixedThreadPool(10, Thread::new)) {
      IntStream.range(0, 10).forEach(el -> executorService.execute(() -> runJob(el)));

      println("Queue:");
      queue.forEach(el -> println("el:", el));

      assertTrue(queue.poll().contains("[0 - Thread"));
      assertTrue(queue.poll().contains("[1 - Thread"));
      assertTrue(queue.poll().contains("[2 - Thread"));
      assertTrue(queue.poll().contains("[3 - Thread"));

      // Initiates an orderly shutdown in which previously submitted tasks are executed, but no new
      // tasks will be accepted.
      executorService.shutdown();

      // Blocks until all tasks have completed execution after a shutdown request
      if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
        printError("Executor did not terminate");
        executorService.shutdownNow();
      }

    } catch (InterruptedException e) {
      printlnError(e, 3);
      Thread.currentThread().interrupt();
    }
  }

  private void runJob(int el) {
    try {
      semaphore.acquire();
      println("number: ", el);
      queue.add("[%s - %s]".formatted(el, Thread.currentThread().getName()));
    } catch (InterruptedException e) {
      printErrorStatic(e.toString());
      Thread.currentThread().interrupt();
    } finally {
      semaphore.release();
    }
  }
}
