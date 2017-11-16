package bitwise_shift_right_and_left;

public class BitwiseShiftRightLeft {

    public static void main(String[] args) {

        int number = 276;
        printToBinary(number);
        verificationPrint(number);

        int num_01 = number << 1;
        printToBinary(num_01);
        verificationPrint(num_01);

        int num_02 = number << 2;
        printToBinary(num_02);
        verificationPrint(num_02);

        int num_03 = number << 8;
        printToBinary(num_03);
        verificationPrint(num_03);

    }

    private static void printToBinary(int number) {
        String replace = String
                .format(
                        "%8s",
                        Integer.toBinaryString(number))
                .replace(' ', '0');
        System.out.println("number: " + number + ", binary: " + replace);
    }

    private static void verificationPrint(int number) {
        String binaryString = Integer.toBinaryString(number);
        System.out.println("verification number: " + binaryString + "\n");
    }

}
