package example_01;

/**
 * Simple example of using lambda expressions.
 *
 * @author malex
 */
public class Main_Lambda_01 {

   public static void main(String[] args) {
      Operationable operation;

      operation = (x, y) -> x + y;
      System.out.println("(x, y) -> x + y; \n result: " + operation.calculate(2, 4));

      Operationable operation1 = (int x, int y) -> x / y;
      Operationable operation2 = (int x, int y) -> x - y;
      Operationable operation3 = (int x, int y) -> x * y;

      System.out.println(" operation1 " + operation1.calculate(10, 4));
      System.out.println(" operation2 " + operation2.calculate(2, 4));
      System.out.println(" operation3 " + operation3.calculate(2, 4));

   }
}

/**
 * Functional interface.
 */
interface Operationable {

   /**
    * Functional interface must contain only a single method with no implementation.
    */
   int calculate(int x, int y);

}