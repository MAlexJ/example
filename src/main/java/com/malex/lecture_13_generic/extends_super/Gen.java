package com.malex.lecture_13_generic.extends_super;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public class Gen<T extends Number>
{
    private static final double DEFAULT_VALUE = 0.0;
    private T[] array;

    private double average()
    {
        return Arrays.stream(array)
                .mapToDouble(Number::doubleValue)
                .average()
                .orElse(DEFAULT_VALUE);
    }

    public boolean sameAvg(Gen<? extends Number> ob)
    {
        return average() == ob.average();
    }

    public boolean sameAvgShort(Gen<? super Short> ob)
    {
        return average() == ob.average();
    }
}
