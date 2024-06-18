package com.malex.lecture_11_record;

import static com.malex.lecture_11_record.RecordImplementInterface.MyRecord.from;
import static junit.framework.TestCase.assertTrue;

import com.malex.utils.AbstractUtils;
import java.util.Comparator;
import java.util.Objects;
import org.junit.Test;

public class RecordImplementInterface extends AbstractUtils {

  @Test
  public void interfaceMethod() {
    var first = from("A");
    var second = from("B");

    int compare = Objects.compare(first, second, Comparator.naturalOrder());
    assertTrue(compare < 0);

    var rawA = new MyRecordRaw("A");
    var rawB = new MyRecordRaw("B");
    try {
      Objects.compare(rawA, rawB, Comparator.naturalOrder());
    } catch (java.lang.StackOverflowError e) {
      // none
    }
  }

  private record MyRecordRaw(String val) implements Comparable {
    @Override
    public int compareTo(Object o) {
      return this.compareTo(o);
    }
  }

  record MyRecord(String val) implements Comparable<MyRecord> {

    static MyRecord from(String val) {
      return new MyRecord(val);
    }

    @Override
    public int compareTo(MyRecord o) {
      return this.val.compareTo(o.val);
    }
  }
}
