package task_01;

/**
 * Created by Alex on 4/9/2015.
 */
public class ParcelTestMain_1 {

    class ParcelInt {
        private int i = 11;

        public ParcelInt() {
        }

        public int value(String str) {
            int result = Integer.valueOf(str);
            return i + result;
        }
    }

    class ParcelString {
        private String label;

        public ParcelString(String whereTo) {
            label = whereTo;
        }

        public String readLabel() {
            return label;
        }
    }


    public static void main(String[] args) {
        // Error ->  ParcelInt parcelInt = new ParcelInt();
        ParcelTestMain parcelTestMain = new ParcelTestMain();



    }

}
