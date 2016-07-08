import java.util.Random;

public class LineGeneration {

    public static void main(String[] args) {
        LineGeneration generation = new LineGeneration();
        System.out.println(generation.stringGeneration(10));
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
