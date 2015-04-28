package task_04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;

/**
 * Created by admin on 26.04.2015.
 */
public class CopyFileNIO {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\admin\\Documents\\example\\src\\main\\lecture_17_IO\\source\\file11.txt");

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

        Path FROM = Paths.get("C:\\Users\\admin\\Documents\\example\\src\\main\\lecture_17_IO\\source\\file11.txt");
        Path TO = Paths.get("C:\\Users\\admin\\Documents\\example\\src\\main\\lecture_17_IO\\destination\\file11.txt");

        //overwrite existing file, if exists
        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.COPY_ATTRIBUTES,
                StandardCopyOption.REPLACE_EXISTING,
        };
        try {


            Files.copy(FROM, TO, options);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
