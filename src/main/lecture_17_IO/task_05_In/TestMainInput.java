package task_05_In;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by admin on 26.04.2015.
 */
public class TestMainInput {

    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            System.out.print(str);


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
