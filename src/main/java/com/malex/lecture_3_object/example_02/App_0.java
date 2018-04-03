package com.malex.lecture_3_object.example_02;

/**
 * Created by Alex on 19.02.2015.
 */
public class App_0 {

    public static void main(String[] args) {

        NumBr numBr = new NumBr();
        numBr.countNum1();
        numBr.countNum2();
        numBr.countNum3();
    }
}

class NumBr {
    int num =10;

    public void countNum1 (){
        int num =20;
        System.out.println(num+num);
    }

    public void countNum2 (){
        int num =20;
        System.out.println(this.num+num);
    }


    public void countNum3 (){
        System.out.println(num+num);
    }

}
