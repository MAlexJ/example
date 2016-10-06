package example_01;

/**
 * Simple example of using lambda expression.
 * The method of functional interface without parameters.
 *
 * @author malex
 */
public class Main_Lambda_02 {

   public static void main(String[] args) {

      Operationable operation = () -> 20 + 40;
      System.out.println(" () -> 20 + 40;  \n result: " + operation.method());

      Exampleable exampleable1 = (x) -> x + 2;
      System.out.println(" (x) -> x + 2;  \n result: " + exampleable1.method(2));

      Exampleable exampleable2 = x -> x * 3;
      System.out.println(" x -> x * 3;  \n result: " + exampleable2.method(2));
   }
}

/**
 * Functional interface.
 */
interface Operationable {

   /**
    * Method without parameters.
    *
    * @return result
    */
   int method();
}

/**
 * Functional interface.
 */
interface Exampleable {

   /**
    * Method has one parameter.
    *
    * @param x input value.
    * @return result calculation.
    */
   int method(int x);

}


