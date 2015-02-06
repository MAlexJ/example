import java.util.ArrayList;

/**
 * Created by Alex on 06.02.2015.
 */
public class App_06_Generic {

    public static void main(String[] args) {

        // они все его потомки ? extends Number
        ArrayList<? extends Number> list0 = new ArrayList<Integer>();

        Integer i = null;
        //   list0.add(i);
        Number n = null;
        //   list0.add(n);

        //runtime error
        // Number xxx = list0.get(0);

        list0.add(null);

        // они все его потомки ? extends
        ArrayList<? extends Object> list1 = new ArrayList<String>();
    }
}
