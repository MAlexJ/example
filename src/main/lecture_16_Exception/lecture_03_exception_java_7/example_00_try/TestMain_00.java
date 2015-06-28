package lecture_03_exception_java_7.example_00_try;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestMain_00 {

    public static void main(String[] args) {
        BufferedReader br = null;
        FileReader fileReader = null;

        try {

            fileReader = new FileReader("price_product.txt");

            br = new BufferedReader(fileReader);
            while (br.read() > 0)
                System.out.println(br.readLine());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();


        } finally {

            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}
