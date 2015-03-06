package task_02_equals;

/**
 * Created by Alex on 06.03.2015.
 */
public class App_02_equalsIgnoreCase {

    public static void main(String args[]) {
        String str1 = new String("This is really not immutable!!");
        String str3 = new String("This is really not immutable!!");
        String str4 = new String("This IS REALLY NOT IMMUTABLE!!");
        boolean retVal;

        retVal = str1.equals(str3);
        System.out.println("str1.equals( str3 ) = " + retVal);

        retVal = str1.equals(str4);
        System.out.println("str1.equals( str4 ) = " + retVal);

        retVal = str1.equalsIgnoreCase(str4);
        System.out.println("str1.equalsIgnoreCase( str4  = " + retVal);
    }

}
