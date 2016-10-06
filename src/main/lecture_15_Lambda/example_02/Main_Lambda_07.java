package example_02;

/**
 * Reference method as method parameters/
 *
 * @author malex
 */
public class Main_Lambda_07 {

   public static void main(String[] args) {
      int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};

      Expression_01 expr = ExpressionHelper::isEven;
      System.out.println(sum(nums, expr));

      expr = ExpressionHelper::isPositive;
      System.out.println(sum(nums, expr));
   }

   private static int sum(int[] numbers, Expression_01 func) {
      int result = 0;
      for (int i : numbers) {
         if (func.isEqual(i))
            result += i;
      }
      return result;
   }
}

/**
 * Functional interface.
 */
interface Expression_01 {
   boolean isEqual(int n);
}

/**
 * Class with method
 */
class ExpressionHelper {

   static boolean isEven(int n) {
      return n % 2 == 0;
   }

   static boolean isPositive(int n) {
      return n > 0;
   }
}