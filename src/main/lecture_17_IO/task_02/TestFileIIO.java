package task_02;

import java.io.File;

/**
 * Created by admin on 26.04.2015.
 */
public class TestFileIIO {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\admin\\Documents\\example\\src\\main\\lecture_17_IO\\source\\file.txt");

        System.out.println(file.isDirectory());
        System.out.println(file.getName());
        System.out.println(file.exists());
       // file.delete();


    }
}
