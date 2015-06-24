package lecture_03_exception_java_7.example_00_try;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestMain_00 {

    public static void main(String[] args) {
        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader("price_product.txt"));
            while (br.read() > 0)
                System.out.println(br.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}
