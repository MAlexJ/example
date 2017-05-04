package equals_and_hachcode.test;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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

    }

    /**
     * Transitive: For any non-null reference values x, y, z, if x.equals(y) returns true
     * and y.equals(z) returns true, then x.equals(z) must return true
     */
    @Test
    public void test_Transitive() {

    }

    /**
     * Consistent: For any non-null reference values x and y, multiple invocations of x.equals(y)
     * consistently return true or consistently return false,
     * provided no information used in equals comparisons on the objects is modified.
     */
    @Test
    public void test_Consistent() {

    }

    /**
     * For any non-null reference value x, x.equals(null) must return false
     */
    @Test
    public void test_non_null_reference() {

    }
}
