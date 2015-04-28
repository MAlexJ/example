package task_01;

import java.io.*;

/**
 * Created by admin on 26.04.2015.
 */
public class TestInputStream {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\admin\\Documents\\example\\src\\main\\lecture_17_IO\\source\\file.txt");

        //Создание файла
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Наполнение файла
        DataOutputStream dataOutputStream = null;
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(file);
            dataOutputStream = new DataOutputStream(output);



            dataOutputStream.writeChars("c");
            dataOutputStream.writeChars("b");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.flush();
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (dataOutputStream != null) {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DataInputStream dataInput = null;
        FileInputStream input = null;
        try {
            input = new FileInputStream(file);
            dataInput = new DataInputStream(input);
            System.out.println(dataInput.readChar());
            System.out.println(dataInput.readChar());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (dataInput != null) {
                try {
                    dataInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
