package task_01;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample {

    /**
     * public class ArrayList<E> extends AbstractList<E>
     implements List<E>, RandomAccess, Cloneable, java.io.Serializable
     */
private static List<Profile> listProfile = new ArrayList<>();

    public static void main(String[] args) {

        Profile profile = new Profile();

        System.out.println(profile);
        System.out.println("listProfile.size() -> "+listProfile.size());

        profile.setName(JOptionPane.showInputDialog(null, "Введите Ваше имя"));
        profile.setSurname(JOptionPane.showInputDialog(null,"Введите Вашу фамилию"));

        listProfile.add(profile);

        for (Profile iter:listProfile) {
            System.out.println(iter);
        }
        System.out.println("listProfile.size() -> "+listProfile.size());
    }

}
