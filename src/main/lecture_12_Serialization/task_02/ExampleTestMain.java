package task_02;

import java.util.ArrayList;
import java.util.List;


public class ExampleTestMain {

    private static List<BulletinBoard> listBoard = new ArrayList<>();
    private static SerializClass serializClass = new SerializClass();

    public static void main(String[] args) {
        /** Deserialize object */
        /** You must have the file "dao_file.ser" */
//        listBoard = (List<BulletinBoard>) serializClass.deserData("dao_file.ser");
        System.out.println(">>> listProfile.size() -> " + listBoard.size());

//        for (BulletinBoard iter : listBoard) {
//            System.out.println(iter);
//        }

        /** Create Entity */
//        BulletinBoard board_01 = new BulletinBoard(1, "User", new Date(), "AUTO", "Shop auto", "Профессиональное диагностическое оборудование");
//        BulletinBoard board_02 = new BulletinBoard(1, "User", new Date(), "AUTO", "Shop auto", "Профессиональное диагностическое оборудование");
//        BulletinBoard board_03 = new BulletinBoard(1, "User", new Date(), "AUTO", "Shop auto", "Профессиональное диагностическое оборудование");
//        BulletinBoard board_04 = new BulletinBoard(1, "User", new Date(), "AUTO", "Shop auto", "Профессиональное диагностическое оборудование");
//        BulletinBoard board_05 = new BulletinBoard(1, "User", new Date(), "AUTO", "Shop auto", "Профессиональное диагностическое оборудование");
//        listBoard.add(board_01);
//        listBoard.add(board_02);
//        listBoard.add(board_03);
//        listBoard.add(board_04);
//        listBoard.add(board_05);
//        System.out.println(">>> listProfile.size() -> " + listBoard.size());

        /** Serialization of an object */
       // serializClass.serData("dao_file", listBoard);

    }


}
