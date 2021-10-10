package com.malex.lecture_6_BigDecimal;

import java.math.BigDecimal;

/**
 * Created by malex on 28.07.16.
 */
public class MainBigDecimalEquals {

    public static void main(String[] args) {

        BigDecimal result = new BigDecimal("12345");
        BigDecimal constVal = new BigDecimal("100000000");

        System.out.println("ifn result < constVal = "+ result.compareTo(constVal));


    }

}
