package com.malex.lecture_13_generic.extends_super;

public class AppRun
{
    public static void main(String[] args)
    {
        // <? extends Number> Number <- Double ..... Byte
        Gen<Integer> genInt = new Gen<>(new Integer[]{1, 2, 3, 4, 5});
        Gen<Double> genDouble = new Gen<>(new Double[]{1.0, 2.0, 3.0, 4.0, 5.0});
        System.out.println(genInt.sameAvg(genDouble));

        // <? super Short> only ->>>> Short
        Gen<Short> genShort = new Gen<>(new Short[]{1, 2, 3, 4, 5});
        System.out.println(genInt.sameAvgShort(genShort));

        Gen<Byte> genByte = new Gen<>(new Byte[]{1, 2, 3, 4, 5});
//        System.out.println(genInt.sameAvgShort(genByte)); // Gen cannot applied to Gyte
    }
}