package task_02;

import java.io.*;

public class SerializClass {

    // This method is intended for serialization of the object
    public static void serData(String file_name, Object obj) {

        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream(file_name + ".ser");
            out = new ObjectOutputStream(fileOut);
//          out = new ObjectOutputStream(new FileOutputStream(file_name + ".ser"));
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
                out.flush();
                out.close();
            } catch (IOException e) {
                System.err.println("Ошибка закрытия ресурсов " + e);
            }
        }
    }

    // This method is intended for deserialization of an object
    public static Object deserData(String file_name) {
        FileInputStream fileInput = null;
        ObjectInput in = null;
        Object retObject = null;

        try {
            fileInput = new FileInputStream(file_name);
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
            }
        }
        return retObject;
    }
}
