package task_01;


public class ParcelTestMain {

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

    public int goParselInt(String str) {
        ParcelInt parcelInt = new ParcelInt();
        return parcelInt.value(str);
    }

    public String goParselString(String str) {
        ParcelString parcelString = new ParcelString(str);
        return parcelString.readLabel();
    }

    public static void main(String[] args) {
        // Error ->  ParcelInt parcelInt = new ParcelInt();
        ParcelTestMain parcelTestMain = new ParcelTestMain();

        System.out.println(parcelTestMain.goParselInt("1234"));

        System.out.println(parcelTestMain.goParselString("String"));


    }
}
