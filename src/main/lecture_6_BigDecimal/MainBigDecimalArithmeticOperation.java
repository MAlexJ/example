import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MainBigDecimalArithmeticOperation {

    private static BigDecimal result;

    public static void main(String[] args) {

//        // Add
//        System.out.println(">>> +");
//        result = calculate(new BigDecimal("-123"), new BigDecimal("32"), "+");
//        System.out.println(result);
//        result = calculate(new BigDecimal("0"), new BigDecimal("-1"), "+");
//        System.out.println(result);
//        result = calculate(new BigDecimal("1"), new BigDecimal("-1"), "+");
//        System.out.println(result);
////        result = calculate(new BigDecimal(String.valueOf(Integer.MIN_VALUE)), new BigDecimal(String.valueOf(Integer.MAX_VALUE)), "+");
//        result = calculate(new BigDecimal(Integer.MIN_VALUE), new BigDecimal(Integer.MAX_VALUE), "+");
//        System.out.println(result);
//
//        result = calculate(new BigDecimal(String.valueOf(Double.MIN_VALUE)), new BigDecimal(String.valueOf(Double.MAX_VALUE)), "+");
//        System.out.println(result);
//
//        System.out.println("\n>>> - <<<<");
//        result = calculate(new BigDecimal("123"), new BigDecimal("32"), "-");
//        System.out.println(result);
//        result = calculate(new BigDecimal("0"), new BigDecimal("-1"), "-");
//        System.out.println(result);
//        result = calculate(new BigDecimal("1"), new BigDecimal("-1"), "-");
//        System.out.println(result);
//        result = calculate(new BigDecimal(Integer.MIN_VALUE), new BigDecimal(Integer.MAX_VALUE), "-");
//        System.out.println(result);

//        //Div
//        result = calculate(new BigDecimal("1.1"), new BigDecimal("0"), "/"); //TODO ArithmeticException: / by zero
//        System.out.println(result);
////
//        result = calculate(new BigDecimal("1"), new BigDecimal("3"), "/");
//        System.out.println(result.stripTrailingZeros()); //
//        result = calculate(new BigDecimal("1"), new BigDecimal("4"), "/");
//        System.out.println(result.stripTrailingZeros()); // TODO ->  http://pr0java.blogspot.com/2015/05/biginteger-bigdecimal_70.html

//        BigDecimal num = new BigDecimal("1");
//        BigDecimal den = new BigDecimal("4");
//        MathContext mc = new MathContext(9, RoundingMode.HALF_EVEN);
//        BigDecimal res = num.divide(den, mc).setScale(9, RoundingMode.HALF_EVEN);
//        System.out.println(res);
    }

    /**
     * Числа BigDecimal являются неизменными.
     * Это означает, что если создаётся новый объект BigDecimal со значением "2.00",
     * такой объект останется "2.00" и никогда не может быть изменён.
     * <p>
     * Так как же тогда выполняются математические расчёты?
     * Методы .add(), .multiply() и другие возвращают новый объект BigDecimal, содержащий результат.
     */
    static BigDecimal calculate(BigDecimal num1, BigDecimal num2, String operation) {
        switch (operation) {
            case "+":
                return num1.add(num2);
            case "-":
                return num1.subtract(num2);
            case "*":
                return num1.multiply(num2);
            case "/":
                return num1.divide(num2, 9, BigDecimal.ROUND_HALF_UP);
            default:
                throw new IllegalArgumentException("Оператора " + operation + " нет в списке операций");
        }
    }
}
