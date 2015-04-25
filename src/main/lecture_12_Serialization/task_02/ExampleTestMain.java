package task_02;

import java.util.ArrayList;
import java.util.List;


public class ExampleTestMain {
    private static List<ProfileSerializ> listProfile = new ArrayList<>();

    public static void main(String[] args) {
        /** Deserialize object */
        /** You must have the file "profile.ser" */
        //listProfile = (List<ProfileSerializ>) SerializClass.deserData("profile.ser");
        System.out.println("listProfile.size() -> " + listProfile.size());

        for (ProfileSerializ iter : listProfile) {
            System.out.println(iter);
        }

        // Check the size of the list -> List<ProfileSerializ>
//        ProfileSerializ profile_01 = new ProfileSerializ("A21", "A22", "A33");
//        ProfileSerializ profile_02 = new ProfileSerializ("A21", "A22", "A33");
//        ProfileSerializ profile_03 = new ProfileSerializ("A21", "A22", "A33");
//        ProfileSerializ profile_04 = new ProfileSerializ("A21", "A22", "A33");
//        listProfile.add(profile_01);
//        listProfile.add(profile_02);
//        listProfile.add(profile_03);
//        listProfile.add(profile_04);

        // Check the size of the list -> List<ProfileSerializ>
        System.out.println(listProfile.size());

        /** Serialization of an object */
       // SerializClass.serData("profile", listProfile);

    }


}
