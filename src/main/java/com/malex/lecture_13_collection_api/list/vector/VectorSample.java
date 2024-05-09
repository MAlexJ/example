package vector;

import java.util.Vector;
import org.junit.Test;

/**
 * @author malex
 */
public class VectorSample {

  /** Start the app */
  @Test
  public void test() {

    // #1 create a new vector
    createVector(1, 2, 3, 4, 5, 6, 6, 7, 8, 88, 9);

    // #2 add a new element into the vector
    System.out.println("");
    System.out.println(
        ">>> Vector creates an empty vector of size 10 and with capacityIncrement = 0 ");
    Vector<Integer> vector = createVector(123, 34, 5, 57, 3, 8, 2, 3, 4, 4);
    System.out.println("src: " + vector + "; capacity: " + vector.capacity());
    // synchronized
    vector.add(12);
    System.out.println("dest: " + vector + "; capacity: " + vector.capacity());

    // #3 remove delete one element
    System.out.println("");
    System.out.println(">>> remove element index[10]: " + vector.remove(10));
    System.out.println("dest: " + vector + "; capacity: " + vector.capacity());

    // #4 get first element
    System.out.println();
    System.out.println(">>>> get first element: " + vector.firstElement());

    // #5 get last element
    System.out.println();
    System.out.println(">>>> get last element: " + vector.lastElement());
  }

  /**
   * Create new vector
   *
   * @param elements are simple integer numbers
   * @return the vector with data
   */
  private Vector<Integer> createVector(int... elements) {
    Vector<Integer> result = new Vector<>();
    for (int element : elements) {
      result.add(element);
    }
    return result;
  }
}
