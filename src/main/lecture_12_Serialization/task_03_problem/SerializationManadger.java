package task_03_problem;

import java.io.*;

/**
 * Created by Alex on 06.03.2015.
 */
public class SerializationManadger  {

    // This method is intended for serialization of the object
    public static void serializationObject(String fileName, String fileExtension, Object obj) {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream(fileName + "." + fileExtension);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден ");
        } catch (IOException e) {
            System.err.println("Ошибка ввода вывода ");
        }
        // Closing resources FileOutputStream, ObjectOutputStream
        finally {
            try {
                fileOut.close();
                out.close();
            } catch (IOException e) {
                System.err.println("Ошибка закрытия ресурсов " + e);
                System.exit(1);
            }
        }
    }


    // This method is intended for deserialization of an object
    public static Object deserializationObject(String fileName, String fileExtension) {
        FileInputStream fileInput = null;
        ObjectInput in = null;
        Object retObject = null;

        try {
            fileInput = new FileInputStream(fileName + "." + fileExtension);
            in = new ObjectInputStream(fileInput);
            retObject = in.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден ");
        } catch (IOException e) {
            System.err.println("Ошибка ввода вывода ");
        } catch (ClassNotFoundException e) {
            System.err.println("Ошибка ClassNotFoundException ");
        }
        // Closing resources FileInputStream, ObjectInputStream
        finally {
            try {
                fileInput.close();
                in.close();
            } catch (IOException e) {
                System.err.println("Ошибка закрытия ресурсов " + e);
                System.exit(1);
            }
        }
        return retObject;
    }


}
