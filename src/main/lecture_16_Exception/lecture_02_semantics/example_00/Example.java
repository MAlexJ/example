package lecture_02_semantics.example_00;


import java.io.File;
import java.io.IOException;

public class Example {
    // заказчик
    public static void main(String[] args) {

        try {
            saveState();
        } catch (SaveException e) {
            System.out.println();
        }

    }

    //Начальник стройки
    public static void saveState() throws SaveException {
        // saveToDB();       //Db exppoo
        // saveToInternet(); // intr5Exce
        try {
            saveToFile();        // file Excc
        } catch (FSException e) {
           throw  new SaveException("Временные проблемы на стойке",e);
        }
    }

    //прораб
    public static void saveToFile() throws FSException {
        createFile();
        // writeToFile();
        //createDublFile();

    }

    //рабочий
    public static void createFile() throws FSException {
        String str = "Cc:/text.txt";
        try {
            new File(str).createNewFile();
        } catch (IOException e) {
             throw new FSException(">>>>>  createFile()->"+str, e);
        }
    }

}

class MonitorExc extends  Exception {

    public MonitorExc(String message, Throwable cause) {
        super(message, cause);
    }
}

class FSException extends MonitorExc {

    public FSException(String message, Throwable cause) {
        super(message, cause);
    }
}

class SaveException extends MonitorExc {

    public SaveException(String message, Throwable cause) {
        super(message, cause);
    }
}