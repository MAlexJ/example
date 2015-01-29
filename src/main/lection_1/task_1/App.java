package task_1;

import org.apache.log4j.Logger;

/**
 * Created by admin on 29.01.2015.
 * <p/>
 * Exchange values through an additional variable
 */
public class App {
    private final static Logger LOG = Logger.getLogger(App.class);

    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        int tmp = a;
        a = b;
        b = tmp;

        LOG.debug("a = " + a);
        LOG.debug("b = " + b);

    }
}
