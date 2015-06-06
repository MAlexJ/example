package example_02_array_two;

/**
 * Created by Alex on 05.06.2015.
 */
public class Task_06 {
    public static void main(String[] args) {

        int[][] da = new int[6][4];
        for (int i = 0; i < da.length; i++) {
            for (int j = 0; j < da[i].length; j++) {
                da[i][j] = (int) (Math.random() * 10);
            }
        }
        for (int i = 0; i < da.length; i++) {
            for (int j = 0; j < da[i].length; j++) {
                System.out.print(da[i][j] + "\t");
            }
            System.out.println(); // Переходим на следующую строку
        }


    }

}
