package com.malex.lecture_4_vararg;

import com.malex.lecture_13_collection_api.list.AbstractBase;
import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class VarArgSimpleUsage extends AbstractBase {

  @Test
  public void simpleImpl() {
    vararg(1);
    vararg();
    vararg(1, 2, 3, 7);

    // example 2
    varargWithFirstRequiredElement(1);
    varargWithFirstRequiredElement(1, 1, 2, 6, 9);
  }

  private void vararg(int... varArg) {
    StringBuilder sb = new StringBuilder("nums: ");
    for (int item : varArg) {
      sb.append(item).append(",");
    }
    println(sb.toString());
  }

  private void varargWithFirstRequiredElement(int first, int... varArg) {
    StringBuilder sb = new StringBuilder("first: ");
    sb.append(first).append("; ");
    for (int item : varArg) {
      sb.append(item).append(",");
    }
    println(sb.toString());
  }
}
