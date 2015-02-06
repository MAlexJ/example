package task_0;


public class App_primitive {

    public static void main(String[] args) {

        byte b = 5;
        short s = 10;
        int i = 20;
        long l = 10L;
        char c = 68;
        float f = 10.0f;
        double d = 10.2;

        //------------------------------->
        //short
        short numShort = b; // byte b = 5;
        //int
        int intNum0 = b; //   byte b = 5;
        int intNum1 = s; // short s =10;
        int intNum2 = c; // char c =68;
        //long
        long longNum = b; // byte b = 5;
        long longNum0 = s;  // short s =10;
        long longNum1 = c;// char c =68;
        long longNum2 = i; //int i = 20;
        //double
        double doubleNum = i; //int i = 20;
        double doubleNum0 = f; //10.0f;

        //- - - - - - - - - - - - - - ->
        //float
        float floatNum0 = f + i; // float + int
        float floatNum1 = f + l; // float + long
        //double
        double doubleNum1 = d + l; // double + long
        double doubleNum2 = d + i; // double + int
        double doubleNum3 = d + f; // double + float

        //*********************************>
        //(type)type
        float floatNum2 = (float) d + f; // double + float
        // float floatNum2 = d + f -> error

        int intNum3 = i + (int) l;
        // int intNum3 = i + l -> error
    }

}
