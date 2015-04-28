package task_05_In;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestMainInput {

    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            int i = 0;
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.print("Не строка");
            }

            System.out.print(i);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
