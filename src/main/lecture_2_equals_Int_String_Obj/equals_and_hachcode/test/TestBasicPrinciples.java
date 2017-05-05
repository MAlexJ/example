package equals_and_hachcode.test;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Testing the basic principles
 */
public class TestBasicPrinciples {

   /**
    * Reflexive: For any non-null reference value x, x.equals(x) must return true
    */
   @Test
   public void test_Reflexive() {
      TUser user = new TUser(1, "NAME");
      assertEquals(user, user);
   }

   /**
    * Symmetric: For any non-null reference values x and y, x.equals(y) must return true
    * if and only if y.equals(x) returns true
    */
   @Test
   public void test_Symmetric() {
      TUser userX = new TUser(2, "X");
      TUser userY = new TUser(2, "X");

      assertTrue(userX.equals(userY));
      assertTrue(userY.equals(userX));

      assertEquals(userX, userY);
      assertEquals(userY, userX);
   }

   /**
    * Transitive: For any non-null reference values x, y, z, if x.equals(y) returns true
    * and y.equals(z) returns true, then x.equals(z) must return true
    */
   @Test
   public void test_Transitive() {
      TUser userX = new TUser(2, "X");
      TUser userY = new TUser(2, "X");
      TUser userZ = new TUser(2, "X");

      assertTrue(userX.equals(userY));

      assertTrue(userX.equals(userZ));
      assertTrue(userY.equals(userZ));
   }

   /**
    * Consistent: For any non-null reference values x and y, multiple invocations of x.equals(y)
    * consistently return true or consistently return false,
    * provided no information used in equals comparisons on the objects is modified.
    */
   @Test
   public void test_Consistent() {
      TUser userX = new TUser(2, "X");
      TUser userY = new TUser(2, "X");

      for (int i = 0; i < 20; i++) {
         assertTrue(userX.equals(userY));
         assertTrue(userY.equals(userX));
      }
   }

   /**
    * For any non-null reference value x, x.equals(null) must return false
    */
   @Test
   public void test_non_null_reference() {
      TUser userX = new TUser(2, "X");

      assertFalse(userX.equals(null));
   }
}
