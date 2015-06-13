package example_01;

public class TaskMain_01_for {

    public static void main(String[] args) {

        // task: 1 2 4 8 16 32 64 128
        // amount of numbers
        int n = 8;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result = 1;
                System.out.println(result);
            } else {
                result = result * 2;
                System.out.println(result);
            }
        }
    }
}
