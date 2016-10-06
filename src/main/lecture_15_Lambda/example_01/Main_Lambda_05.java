package example_01;

/**
 * Simple example generalized functional interface.
 *
 * @author malex
 */
public class Main_Lambda_05 {

   public static void main(String[] args) {

      LambdaInterface<Integer> lmbInteger = (x, y) -> {
         if (x > y)
            return x + y;
         else
            return x - y;
      };

      LambdaInterface<String> lmbString = (x, y) -> {
         if (x.isEmpty() || y.isEmpty()) {
            return "Result empty!";
         }
         return x + y;
      };

      System.out.println("Result: " + lmbInteger.calculate(12, 14));
      System.out.println("Result: " + lmbString.calculate("start_", "finish"));

   }
}

/**
 * Generalized functional interface.
 *
 * @param <T> functional interface
 */
interface LambdaInterface<T> {
   T calculate(T x, T y);
}
