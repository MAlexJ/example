
public class Break_label_goto {

    public static void main(String[] args) {

        boolean flag = true;
        first:
        {
            System.out.println("first -> in");

            second:
            {
                System.out.println(" second -> in");

                third:
                {
                    System.out.println("  third -> in");
                    if (flag) {
                        break second;
                    }
                    System.out.println("  third -> out");
                }
                System.out.println(" second -> out");
            }
            System.out.println("first -> out");
        }

    }

}
