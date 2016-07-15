import java.math.BigInteger;
import java.util.Random;

public class LineGeneration {
    private static final int MAXIMUM_NUMBER_APARTMENTS = 4;

    public static void main(String[] args) {
//        LineGeneration generation = new LineGeneration();
//        System.out.println(generation.stringGeneration(10));


//        BigInteger number = new BigInteger(String.valueOf(Integer.MAX_VALUE));
//        System.out.println(number);
//        BigInteger multiply = number.multiply(new BigInteger(String.valueOf(4)));
//        System.out.println(multiply);
        // 8_589_934_588
        // 8_589_934_588
        // 23_000_000_000

        long maxLimit = Integer.MAX_VALUE;
        long apartment = maxLimit * MAXIMUM_NUMBER_APARTMENTS;

        System.out.println(apartment);

        long num1 =Integer.MAX_VALUE;
        long num2= Integer.MAX_VALUE;
        System.out.println("Максимальный предел этажей (Integer.MAX_VALUE ) : "+num2);
        System.out.println("Максимальный предел квартир в доме (Integer.MAX_VALUE * 4) : "+num2*4);
        System.out.println(Long.MAX_VALUE);

    }

    public String stringGeneration(int numberOfCharacters) {
        if (numberOfCharacters <= 0) {
            throw new ArithmeticException("Incorrect numberOfCharacters: " + numberOfCharacters);
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's',
                'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm',
                'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F',
                'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', '_',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int limit = chars.length - 1;
        for (int i = 0; i < numberOfCharacters; i++) {
            sb.append(chars[new Random().nextInt(limit)]);
        }
        return sb.toString();
    }

}
