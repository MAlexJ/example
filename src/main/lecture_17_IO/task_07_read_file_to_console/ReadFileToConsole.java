package task_07_read_file_to_console;

import java.io.*;

/**
 * Created by malex on 27.02.16.   jav 6 поддержка закрытия ресурсов
 */
public class ReadFileToConsole {
    public static final String SOURCE ="/home/malex/text.txt";
    public static final String DESTINATION ="/home/malex/result.txt";

    public static void main(String[] args) {

        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(SOURCE); //источник
            out = new FileOutputStream(DESTINATION); //приемник

            int s;
            while ((s = in.read()) != -1) {

                System.out.println(s);
                out.write(s);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (in != null) {
                    in.close();
                }

                if (out != null) {
                    out.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
