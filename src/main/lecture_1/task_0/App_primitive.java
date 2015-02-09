package task_0;

/**
 * Лекция 2 (Java SE)
 * Страница 21
 *
 * */
public class App_primitive {

    public static void main(String[] args) {

        // Integer primitive data types
        byte b = 5; // 8bit   / -128 to 128 / -2e7 to 2e7-1
        short s = 10; // 16bit / -2e15 to 2e15-1
        int i = 20; // 32bit  / -2e31 to 2e31-1
        long l = 10L; // 64bit / -2e63 to 2e63-1

        //character primitive data types
        char c = 68; // 32bit

        //fractional primitive data types
        float f = 10.0f; // 32bit
        double d = 10.2; // 64bit

        //Boolean primitive data types
        boolean flag = true;
        boolean stopFlag = false;

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
