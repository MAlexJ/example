package task_03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by admin on 26.04.2015.
 */
public class CopyFileIO {

    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;


        try {
            fileInputStream = new FileInputStream("C:\\Users\\admin\\Documents\\example\\src\\main\\lecture_17_IO\\source\\file.txt");
            fileOutputStream = new FileOutputStream("C:\\Users\\admin\\Documents\\example\\src\\main\\lecture_17_IO\\destination\\file.txt");
            int temp = 0;

            while (true) {
                temp = fileInputStream.read();
                if (temp != -1) {
                    fileOutputStream.write(temp);
                } else {
                    break;
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}


