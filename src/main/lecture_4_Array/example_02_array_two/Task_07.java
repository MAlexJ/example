package example_02_array_two;

/**
 * Created by malex on 07.07.16.
 */
public class Task_07 {
    public static void main(String[] args) {

        //Set count numbers in month and start position New Year
        int[][] arr = getArray(31, 7);

        //Find day
        int findNumber = 25;

        findDay(arr, findNumber);


    }

    private static void findDay(int[][] month, int day) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (month[i][j] == day) {
                    System.out.println("Day of the week: " + findDayByNumber(j));
                }
            }
        }
        System.out.println();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(month[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getArray(int countDay, int countStartDay) {
        int numberDay = 1;
        int numberFinish = 0;

        int[][] arr = new int[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {

                if (--countStartDay <= 0) {
                    if (numberDay <= countDay) {
                        arr[i][j] = numberDay++;
                    } else {
                        arr[i][j] = 0;
                        numberFinish++;
                    }
                }
            }
        }

        if (numberFinish < 7) {
            System.out.println("numberFinish < 7 :" + numberFinish);
            int currentNumberFinish = 8 - numberFinish;
            System.out.println("Начало отчета следующей позиции: " + currentNumberFinish);
        }

        if (numberFinish > 7) {
            System.out.println("numberFinish > 7 :" + numberFinish);
            int currentNumberFinish = 8 - (numberFinish - 7);
            System.out.println("Начало отчета следующей позиции: " + currentNumberFinish);
        }

        if (numberFinish == 7) {
            System.out.println("numberFinish = 7 :" + numberFinish);
            int currentNumberFinish = 1;
            System.out.println("Начало отчета следующей позиции: " + currentNumberFinish);
        }
        return arr;

    }

    private static String findDayByNumber(int numberDay) {
        String[] days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (int i = 0; i < days.length; i++) {
            if (i == numberDay) {
                return days[i];
            }
        }
        return null;
    }
}
