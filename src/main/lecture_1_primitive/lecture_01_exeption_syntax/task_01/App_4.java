package lecture_01_exeption_syntax.task_01;

import org.apache.log4j.Logger;

/**
 * Created by MAlex on 1/30/2015.
 */
public class App_4 {
    private final static Logger LOG = Logger.getLogger(App_4.class);

    public static void main(String[] args) {

        if (LOG.isDebugEnabled()) {
            LOG.debug("main");
        }
        LOG.debug("int a=0 / int b=2: "+ 0/2);

        /*
        Exception java.lang.ArithmeticException: / by zero
        LOG.debug("int a=2 / int b=0: "+ 2/0);
        This result -> Infinity
        */

        LOG.debug("float a=2f / int b=0: "+ 2f/0);

        /* This result -> Infinity */
        LOG.debug("double t a=2d / int b=0: "+ 2d/0);

        /* This result -> 0.0 */
        LOG.debug("int b=0 /double t a=2d "+ 0/2d);

        /* This result -> NaN */
        LOG.debug("double t a=0d / int b=0: "+ 0d/0);

    }
}
