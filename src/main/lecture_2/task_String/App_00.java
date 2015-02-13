package task_String;

import org.apache.log4j.Logger;

/**
 * Created by Alex on 13.02.2015.
 */
public class App_00 {
    private static final Logger LOG = Logger.getLogger(App_00.class);

    public static void main(String[] args) {

        String s1 = new String("Hello");
        String s2 = new String("Hello");
        String s3 = s1;

        LOG.debug("s1==s2: "+s1==s2);
        LOG.debug("s1.equals(s2): "+s1.equals(s2));
        LOG.debug("");
        LOG.debug("s1==s3: "+s1==s3);
        LOG.debug("s1.equals(s3): "+s1.equals(s3));





    }


}
