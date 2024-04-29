package com.malex.lecture_4_vararg;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import java.util.Arrays;
import org.junit.Test;

public class VarargTestSample extends AbstractBase {

  @Test
  public void simpleVarargTest() {
    int[] result = useVararg();
    assertArrayEquals(new int[0], result);

    result = useVararg(1);
    assertArrayEquals(new int[] {1}, result);

    result = useVararg(2, 3, 4, 5);
    assertTrue(compareArrays(new int[] {2, 3, 4, 5}, result));

    result = useVararg(5, 3, 2);
    assertTrue(compareArrays(new int[] {5, 3, 2}, result));
  }

  private int[] useVararg(int... args) {
    println(Arrays.toString(args));
    return args;
  }

  private boolean compareArrays(int[] arr1, int[] arr2) {
    return Arrays.equals(arr1, arr2);
  }
}
