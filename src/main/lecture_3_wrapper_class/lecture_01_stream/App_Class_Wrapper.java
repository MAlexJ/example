package lecture_01_stream;

public class App_Class_Wrapper {
    public static void main(String[] args) {


        /**8x primitive type*/
        byte numbByte = 10;
        short numShort = 15;
        int nubInt = 20;
        long numLong = 25L;
        float numFloat = 12.0f;
        double numDouble = 12.00;
        char literalChar = 's';
        boolean flag = true;

        /** Class Wrapper*/
        Byte b = numbByte;
        Short s = numShort;
        Integer i = nubInt;
        Long l = numLong;
        Float f = numFloat;
        Double d = numDouble;
        Character c = literalChar;
        Boolean boo = flag;

        int number = i + nubInt;

        // auto boxing ->  i.intValue() & auto unboxing.
        System.out.println(number);

    }


}