package task_01_length;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SerializationExample {

    /**
     * public class ArrayList<E> extends AbstractList<E>
     * implements List<E>, RandomAccess, Cloneable, java.io.Serializable
     */
    private static List<BulletinBoard> listBoard = new ArrayList<>();

    public static void main(String[] args) {

        BulletinBoard board_01 = new BulletinBoard(1, "User", new Date(), "AUTO", "Shop auto", "Профессиональное диагностическое оборудование");
        BulletinBoard board_02 = new BulletinBoard(2, "Admin", new Date(), "AUTO", "Shop auto", "Профессиональное диагностическое оборудование");


//        profile.setName(JOptionPane.showInputDialog(null, "Введите Ваше имя"));
//        profile.setSurname(JOptionPane.showInputDialog(null,"Введите Вашу фамилию"));


        listBoard.add(board_01);
        listBoard.add(board_02);

        for (BulletinBoard iter : listBoard) {
            System.out.println(iter);
        }
        System.out.println("listProfile.size() -> " + listBoard.size());
    }

}
