
public class Break_exit_two_cycle {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.print("i=" + i+" -> ");
            for (int j = 0; j < 50; j++) {
                System.out.print(j + " ");
                if (j > 7) {
                    System.out.println();
                    break;
                }
            }
        }
    }
}
