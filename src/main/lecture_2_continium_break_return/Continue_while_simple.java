
public class Continue_while_simple {

    public static void main(String[] args) {
        boolean flag = true;
        int i = 0;
        while (flag) {
            System.out.print(i++);
            if (i % 2 == 0) {
                System.out.print("+");
                continue;
            }
            System.out.println("-");
            if (i >= 20) {
                flag = false;
            }
        }
    }

}
