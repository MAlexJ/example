package lecture_01_exeption_syntax.task_02;

import java.io.*;

public class SerializClass {

    // This method is intended for serialization of the object
    public void serData(String file_name, Object obj) {

        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;

        try {
            fileOut = new FileOutputStream(file_name + ".txt");
            out = new ObjectOutputStream(fileOut);
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            out.writeObject(obj);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден ");
        } catch (IOException e) {
            System.err.println("Ошибка ввода вывода ");
        }

        // Closing resources FileOutputStream, ObjectOutputStream
        finally {
            try {
                if (fileOut != null) {
                    fileOut.close();
                }
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия ресурсов " + e);
            }
        }
    }

    // This method is intended for deserialization of an object
    public Object deserData(String file_name) {
        FileInputStream fileInput = null;
        ObjectInput in = null;
        Object retObject = null;

        try {
            fileInput = new FileInputStream(file_name);
            in = new ObjectInputStream(fileInput);
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
