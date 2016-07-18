import java.math.BigDecimal;

public class MainBigDecimalToStringResult {

    public static void main(String[] args) {
        BigDecimal bigDecimal = BigDecimal.valueOf(100000.0)
                .multiply(BigDecimal.valueOf(100d))
                .stripTrailingZeros();

        System.out.println("plain      : " + bigDecimal.toPlainString());
        System.out.println("scientific : " + bigDecimal.toEngineeringString());
    }

}
