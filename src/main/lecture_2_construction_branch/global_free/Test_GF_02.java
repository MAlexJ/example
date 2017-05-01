package global_free;

/**
 * @author malex
 */
public class Test_GF_02 {

    public static void main(String[] args) {
        String s = "42";

        try {
            s = s.concat(".5");
            System.out.println("s: " + s);

            double d = Double.parseDouble(s);
            System.out.println("d: " + d);

            s = Double.toString(d);

            int x = (int) Math.ceil(Double.valueOf(s).doubleValue());

            System.out.println(x);

        } catch (NumberFormatException ex) {
            System.out.println("Bad number");
        }

    }

}
