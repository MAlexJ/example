package view;

public class HomePage extends AbstractPage {
    private String str;
    private int numberList;


    @Override
    public void showPage() {

        System.out.println("*********************** Begin HomePage *****************************");
        System.out.println(">>>>>>>>>>>> Board <<<<<<<<<<<<<");
        System.out.println("1. View List MyBoard");
        System.out.println("2. View List Board from Users");
        System.out.println("3. View List Board from Context");
        System.out.println("4. Create Board");
        System.out.println("5. Insert Board");
        System.out.println("6. Delete Board");
        System.out.println();
        System.out.println(">>>>>>>>>>>> Context <<<<<<<<<<<<<");
        System.out.println("7. View List Context");
        System.out.println("8. Create Context");
        System.out.println("9. Insert Context");
        System.out.println("10. Delete Context");
        System.out.println();

        try {
            while (true) {
                System.out.println("Enter the number from the list: ");
                str = inputString().readLine();
                if (str.equals("exit")) {
                    close(inputString());
                }
                if (validateNumberInt(str)) {
                    numberList = Integer.parseInt(str);
                    System.out.println("*************** End  HomePage  *****************");
                    System.out.println();
                    display(numberList);
                    return;
                }
                System.out.println("Enter the correct number!!!!");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(">>>>> HomePage  " + e);
        }
    }
}
