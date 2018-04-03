package com.malex.lecture_1_primitive.example_2;

/**
 * При сокращённых операциях в java производится приведение типов.
 * То есть v1+=v2 аналогична v1=(int)(v1+v2)
 * Соответственно в первой строке будет ошибка компиляции так как long шире чем int,
 * а вторая строка успешно выполнится.
 */

public class App_prmitive_1 {

    public static void main(String[] args) {
        int numInt = 1;
        long numLong = 2;

        //??????
        //numInt += numLong;
        //?????
        //numInt = numInt + numLong;
    }
}

