import org.apache.log4j.Logger;

/**
 * Created by Alex on 04.02.2015.
 */
public class App_04_Generic {
    private final static Logger LOG = Logger.getLogger(App_04_Generic.class);

    public static void main(String[] args) {
        WithVersion<String> strV = new WithVersion<>("Mike", 10);
        WithVersion<int[]> intArraV = new WithVersion<>(new int[]{1, 5, 3}, 10);

        //???????????????
        new WithVersion<>();


        if (LOG.isDebugEnabled()) {
            LOG.debug("main");
            LOG.debug(strV);
            LOG.debug(intArraV);

        }
    }
}

// T - type variable
//Generic work only with object. No primitive variable
class WithVersion<T> {
    private T value;
    private int version;

    public WithVersion() {
    }

    public WithVersion(T value, int version) {
        this.value = value;
        this.version = version;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
