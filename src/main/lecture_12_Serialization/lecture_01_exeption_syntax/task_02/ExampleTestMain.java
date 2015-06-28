package lecture_01_exeption_syntax.task_02;

import java.util.ArrayList;


public class ExampleTestMain {

    private static ArrayList<BulletinBoard> listBoard = new ArrayList<>();
    private static SerializClass serializClass = new SerializClass();
    private static BulletinBoard board_00;


    public static void main(String[] args) {
        /** Deserialize object */
        /** You must have the file "dao_file.ser" */

        //board_00 = new BulletinBoard(100, "User_0100", "AUTO1", "Машины", "фывапролывапроывап");
       // serializClass.serData("dao",board_00);
        board_00 =   (BulletinBoard) serializClass.deserData("dao.txt");
        System.out.println(board_00);

//        listBoard = (ArrayList<BulletinBoard>) serializClass.deserData("dao.txt");
//        System.out.println(">>> listProfile.size() -> " + listBoard.size());
//
//        for (BulletinBoard iter : listBoard) {
//            System.out.println(iter);
//        }

        /** Create Entity */
//        BulletinBoard board_01 = new BulletinBoard(1, "User_01", "AUTO", "Машины", "фывапролывапроывап");
//        BulletinBoard board_02 = new BulletinBoard(2, "User_02", "AUTO", "11111", "фывапролывапроывап");
//        BulletinBoard board_03 = new BulletinBoard(3, "User_03", "AUTO2", "Машины", "фывапролывапроывап");
//        BulletinBoard board_04 = new BulletinBoard(4, "User_04", "AUTO3", "333", "фывапролывапроывап");
//        BulletinBoard board_05 = new BulletinBoard(5, "User_05", "AUTO4", "Ма44шины", "фывапролывапроывап");
//        listBoard.add(board_01);
//        listBoard.add(board_02);
//        listBoard.add(board_03);
//        listBoard.add(board_04);
//        listBoard.add(board_05);
//        listBoard.add(new BulletinBoard(6, "User_06", "AUTO5", "555", "фывапролывапроывап"));
//
//        System.out.println(">>> listProfile.size() -> " + listBoard.size());
//
//        System.out.println(listBoard);
//
//        /** Serialization of an object */
//        serializClass.serData("dao", listBoard);

    }


}
