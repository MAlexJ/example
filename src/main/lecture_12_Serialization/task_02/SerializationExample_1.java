package task_02;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SerializationExample_1 {
    private static List<ProfileSerializ> listProfile = new ArrayList<>();

    public static void main(String[] args) {

        // You must have the file "profile.ser"
        // Deserialize object
        listProfile = (List<ProfileSerializ>) deserData("profile.ser");

        // Check the size of the list -> List<ProfileSerializ>
        System.out.println(listProfile.size());

        ProfileSerializ profile = new ProfileSerializ();
        profile.setFirstName(JOptionPane.showInputDialog(null, "Введите FirstName"));
        profile.setMidlName(JOptionPane.showInputDialog(null, "Введите MiddleName"));
        profile.setLastName(JOptionPane.showInputDialog(null, "Введите LastName"));
        listProfile.add(profile);

        // Check the size of the list -> List<ProfileSerializ>
        System.out.println(listProfile.size());

        // Serialization of an object
        serData("profile", listProfile);

    }


    // This method is intended for serialization of the object
    private static void serData(String file_name, Object obj) {

        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream(file_name + ".ser");
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
    private static Object deserData(String file_name) {
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
                System.exit(1);
            }
        }
        return retObject;
    }


}
