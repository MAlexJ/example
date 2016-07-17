import java.math.BigDecimal;
import java.math.BigInteger;

public class MainBigDecimalCreateNumber {

    /**
     * В классе BigDecimal четыре конструктора:
     * <p>
     * BigDecimal (Biglnteger bi) — объект будет хранить большое целое bi, порядок равен нулю;
     * BigDecimal (Biglnteger mantissa, int scale) — задается мантиса mantissa и неотрицательный порядок scale объекта; если порядок scale отрицателен, возникает исключительная ситуация;
     * BigDecimal (double d) — объект будет содержать вещественное число удвоенной точности d ; если значение d бесконечно или NaN , то возникает исключительная ситуация;
     * BigDecimal (String val) — число задается строкой символов val , которая должна содержать запись числа по правилам языка Java.
     */
    public static void main(String[] args) {
        System.out.println("1. >>>  " + new BigDecimal(new BigInteger("1234")));
        try {
            System.out.println(new BigDecimal(new BigInteger("12.34")));

        } catch (NumberFormatException e) {
            System.out.println("2. >>>  " + e.getMessage());
        }
        System.out.println("3. >>>  " + new BigDecimal(new BigInteger("1234"), 2));
        System.out.println("4. >>>  " + new BigDecimal(12.43));
        System.out.println("4. >>>  " + new BigDecimal("12.43"));

        try {
            System.out.println(new BigDecimal(""));
        } catch (NumberFormatException e) {
            System.out.println("5. >>>  if String.isEmpty -> " +  e.getMessage());
        }
    }
}
