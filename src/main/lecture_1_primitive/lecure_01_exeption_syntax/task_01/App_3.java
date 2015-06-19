package lecure_01_exeption_syntax.task_01;

import org.apache.log4j.Logger;

/**
 * Created by admin on 29.01.2015.
 */
public class App_3 {
    private final static Logger LOG = Logger.getLogger(App_3.class);

    public static void main(String[] args) {
        int a = 1_500_000_000;
        int b = 1_600_000_000;

        a = a + b; // a = -1_194_967_296, b = 1_600_000_000
        b = a - b; // a = -1_194_967_296, b = 1_500_000_000
        a = a - b; // a = 1_600_000_000, b = 1_500_000_000

        LOG.debug("a = " + a);
        LOG.debug("b = " + b);
    }
}
