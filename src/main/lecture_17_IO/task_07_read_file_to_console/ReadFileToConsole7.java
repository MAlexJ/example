package task_07_read_file_to_console;

import java.io.*;

/**
 * Created by malex on 27.02.16. java7 закрытие ресурсов происходит автоматически
 */
public class ReadFileToConsole7 {

    public static final String SOURCE = "/home/malex/text.txt";
    public static final String DESTINATION = "/home/malex/result.txt";

    public static void main(String[] args) {
        try (InputStream in = new FileInputStream(SOURCE);
             OutputStream out = new FileOutputStream(DESTINATION)) {
            int s;
            while ((s = in.read()) != -1) {

                System.out.println(s);
                out.write(s);
            }
        } catch (IOException ignored) {
            // NON
        }
    }
}
