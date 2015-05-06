package task_01;

import org.apache.log4j.Logger;

public class App_2 {
    private final static Logger LOG = Logger.getLogger(App_2.class);

    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        a = a ^ b;
        LOG.debug("a - " + a);
        b = a ^ b;
        LOG.debug("b - " + b);
        a = a ^ b;
        LOG.debug("a - " + a);
        LOG.debug("a = " + a);

        LOG.debug("b = " + b);
    }
}
