package com.malex.lecture_9_combination_anp_permutation;

public class CombinationExample {

    private static final char[] ALPHABET = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private static final String SEPARATOR = " ==> ";

    public static void main(String[] args) {
        System.out.println("A" + SEPARATOR + str2int("A") + SEPARATOR + int2str(1));
        System.out.println("B" + SEPARATOR + str2int("B") + SEPARATOR + int2str(2));
        System.out.println("Z" + SEPARATOR + str2int("Z") + SEPARATOR + int2str(26));
        System.out.println("AA" + SEPARATOR + str2int("AA") + SEPARATOR + int2str(27));
        System.out.println("AZ" + SEPARATOR + str2int("AZ") + SEPARATOR + int2str(52));
        System.out.println("BA" + SEPARATOR + str2int("BA") + SEPARATOR + int2str(53));
        System.out.println("ZZ" + SEPARATOR + str2int("ZZ") + SEPARATOR + int2str(702));
        System.out.println("AAA" + SEPARATOR + str2int("AAA") + SEPARATOR + int2str(703));
    }

    public static int str2int(String columnName) {
        int result = 0;
        for (int i = 0; i < columnName.length(); i++) {
            result *= ALPHABET.length;
            result += columnName.charAt(i) - ALPHABET[0] + 1;
        }
        return result;
    }

    public static String int2str(int number) {
        StringBuilder columnName = new StringBuilder();
        while (number > 0) {
            int rem = number % ALPHABET.length;
            if (rem == 0) {
                columnName.append(ALPHABET[ALPHABET.length - 1]);
                number = (number / ALPHABET.length) - 1;
            } else {
                columnName.append((char) ((rem - 1) + ALPHABET[0]));
                number = number / ALPHABET.length;
            }
        }
        return columnName.reverse().toString();
    }

    public static String rightColumn(String columnName) {
        int letterNumber = str2int(columnName) + 1;
        return int2str(letterNumber);
    }
}
