package example_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataEqs {


    public static void main(String[] args) {

        String str = "99-12-Sty";


         Pattern p = Pattern.compile("\\d{1,2}-\\d{2}-[A-Z][a-z]{1,2}");
        //Pattern p = Pattern.compile("\\d{1,4}-\\d{1,2}-[A-Za-z]{3}");
        // Pattern p = Pattern.compile("\\d{2}-\\d\\d-\\D{3}");
        // Pattern p = Pattern.compile("\\D{3}-\\d\\d-\\d{2}");

        Matcher m = p.matcher(str);

        System.out.println(m.matches());


    }
}
