package global_free;

/**
 * @author malex
 */
public class Test_CF_03 {

    public static void main(String[] args) {

        Test_CF_03 t = new Test_CF_03();
        t.start();

    }

    void start() {
        long[] a1 = {3, 4, 5};
        long[] a2 = fix(a1);                               // todo  : Passing by reference
        System.out.print(a1[0] + a1[1] + a1[2]);           // todo  : Arithmetic operation + !!!
        System.out.println(a2[0] + a2[1] + a2[2]);         // todo  : Arithmetic operation + !!!
        // Output: 1515

    }

    // Changes inside array
    long[] fix(long[] a3) {
        a3[1] = 7;                                         // todo : Changes to the current object
        return a3;
    }
}
