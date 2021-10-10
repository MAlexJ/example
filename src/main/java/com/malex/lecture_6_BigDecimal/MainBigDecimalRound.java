package com.malex.lecture_6_BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MainBigDecimalRound {
    public static void main(String[] args) {
//        create();
        rounding(RoundingMode.CEILING, 3, new BigDecimal("12.3444"), new BigDecimal("12.3445"), new BigDecimal("12.3446"));
        rounding(RoundingMode.DOWN, 3, new BigDecimal("12.3444"), new BigDecimal("12.3445"), new BigDecimal("12.3446"));
        rounding(RoundingMode.FLOOR, 3, new BigDecimal("12.3444"), new BigDecimal("12.3445"), new BigDecimal("12.3446"));
        rounding(RoundingMode.HALF_DOWN, 3, new BigDecimal("12.3444"), new BigDecimal("12.3445"), new BigDecimal("12.3446"));
        rounding(RoundingMode.HALF_UP, 3, new BigDecimal("12.3444"), new BigDecimal("12.3445"), new BigDecimal("12.3446"));
        rounding(RoundingMode.HALF_EVEN, 3, new BigDecimal("12.3444"), new BigDecimal("12.3445"), new BigDecimal("12.3446"));
        rounding(RoundingMode.UP, 3, new BigDecimal("12.3444"), new BigDecimal("12.3445"), new BigDecimal("12.3446"));
        try {
            rounding(RoundingMode.UNNECESSARY, 3, new BigDecimal("12.3444"), new BigDecimal("12.3445"), new BigDecimal("12.3446"));
        } catch (ArithmeticException e) {
            System.out.println("\n !!! предполагается, что результат будет целым, и округление не понадобится;  !!");
        }
    }

    /**
     * ROUND_CEILING — округление в сторону большего целого;
     * ROUND_DOWN — округление к нулю, к меньшему по модулю целому значению;
     * ROUND_FLOOR — округление к меньшему целому;
     * ROUND_HALF_DOWN — округление к ближайшему целому, среднее значение округляется к меньшему целому;
     * Округление вверх, если число после запятой > .5
     * ROUND_HALF_EVEN — округление к ближайшему целому, среднее значение округляется к четному числу;
     * ROUND_HALF_UP — округление к ближайшему целому, среднее значение округляется к большему целому;
     * Округление вверх, если число после запятой >= .5
     * ROUND_UNNECESSARY — предполагается, что результат будет целым, и округление не понадобится;
     * ROUND_UP — округление от нуля, к большему по модулю целому значению.
     */
    static void rounding(RoundingMode rounding, int scale, BigDecimal... numbers) {
        System.out.println(">>> " + rounding.name());
        if (rounding.name().equals("HALF_UP")) {
            System.out.println(" >>>> Округление вверх, если число после запятой >= .5  !!");
        }
        for (BigDecimal number : numbers) {
            System.out.print("  Before -> number: " + number + "; ");
            System.out.println("After -> number: " + number.setScale(scale, rounding));
        }
        System.out.println();
    }


    static void create() {
        System.out.println(">>> CREATE BigDecimal >>>");
        BigDecimal num = new BigDecimal("12.34");
        System.out.println(num + "\n");
    }

}
