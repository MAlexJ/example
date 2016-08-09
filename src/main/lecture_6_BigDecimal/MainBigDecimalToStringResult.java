import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainBigDecimalToStringResult {

    public static void main(String[] args) {

//        String pattern = "###############0.##############";
//


        // http://khpi-iip.mipk.kharkiv.edu/library/extent/prog/inter/decimalFormat.html

        MathContext mc = new MathContext(16);

//        BigDecimal num_01 = new BigDecimal("0.00000000000004855004846845542");
//        BigDecimal num_02 = new BigDecimal("1");
        BigDecimal num_01 = new BigDecimal("12412412142412");
        BigDecimal num_02 = new BigDecimal("124124124");

        BigDecimal bigDecimal = num_01
                .multiply(num_02, mc);

        String replaceNorm = bigDecimal.toString();
        System.out.println("replaceNorm "+replaceNorm);
        String replacePlain = bigDecimal.toPlainString();
        System.out.println("replacePlain "+replacePlain);
        String replaceEngineer = bigDecimal.toEngineeringString();
        System.out.println("replaceEngineer "+replaceEngineer + "\n");

        BigDecimal result = new BigDecimal(replaceEngineer);

        DecimalFormat numberFormat = new DecimalFormat();
        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
        unusualSymbols.setExponentSeparator("E");
        String strange = "###0.###";
        DecimalFormat weirdFormatter = new DecimalFormat(strange, unusualSymbols);



        System.out.println(weirdFormatter.format(bigDecimal));

    }

}
