package lecture_01_stream;


public class ParcelTestMain_2 {

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

    public ParcelInt toParcelInt() {
        return new ParcelInt();
    }

    public ParcelString toParcelString(String str) {
        return new ParcelString(str);
    }


    public static void main(String[] args) {
        ParcelTestMain_2 parcelTestMain = new ParcelTestMain_2();

        ParcelInt parcelInt = parcelTestMain.toParcelInt();
        System.out.println(parcelInt.value("234"));

        ParcelString parcelString = parcelTestMain.toParcelString("asdfg");
        System.out.println(parcelString.readLabel());

    }


}
