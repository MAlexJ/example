package com.malex.lecture_11_record;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

import com.malex.utils.AbstractUtils;
import java.util.Objects;
import org.junit.Test;

/**
 * Tutorial: Java 14 Record Keyword
 *
 * <p>link: <a href="https://www.baeldung.com/java-record-keyword">java 14 Record</a>
 */
public final class RecordInJava14 extends AbstractUtils {

  @Test
  public void simple() {
    var newRecord = new NewRecord(1, "test");
    println(newRecord, ", number :", newRecord.number(), ", name :", newRecord.name());
    assertNotNull(newRecord);
  }

  @Test
  public void recordConstructors() {
    var r1 = new RecordDefaultConstructors(1, "text", new Object());
    assertNotNull(r1);

    var r2 = new RecordAllArgsConstructors(2, "empty", "new String()");
    assertNotNull(r2);

    var r3 = new RecordDefaultFiledValue(1);
    assertNotNull(r3);
    assertEquals(r3.address(), "Unknown");

    r3 = new RecordDefaultFiledValue(1, "New text");
    assertNotNull(r3);
    assertEquals(r3.address(), "New text");
  }

  /**
   * Additionally, an equals method is generated for us by the Java compiler.
   *
   * <p>This method returns true if the supplied object is of the same type and the values of all of
   * its fields
   */
  @Test
  public void testEquals() {
    // test 1
    var record1 = new NewRecord(1, "test");
    var record2 = new NewRecord(1, "test");
    assertEquals(record1, record2);
    assertNotSame(record1, record2);

    // test 2
    var record3 = new NewRecord(1, "test");
    var record4 = record3;
    assertEquals(record3, record4);
    assertSame(record3, record4);
  }

  @Test
  public void testHashCode() {
    // test 1
    var record1 = new NewRecord(1, "test");
    var record2 = new NewRecord(1, "test");
    println("hash codes :", record1.hashCode(), record2.hashCode());
    assertEquals(record1.hashCode(), record2.hashCode());

    record1 = new NewRecord(1, "");
    record2 = new NewRecord(2, "test");
    println("hash codes :", record1.hashCode(), record2.hashCode());
    assertNotEquals(record1.hashCode(), record2.hashCode());
  }

  @Test
  public void testToString() {
    var record1 = new NewRecord(1, "test");
    var record2 = new NewRecord(1, "test");
    println("Records :", record1, record2);
    assertTrue(record1.toString().contains("test"));
    assertEquals(record1.toString(), record2.toString());
  }

  /**
   * 1. Records are immutable data classes that require only the type and name of fields.<br>
   * 2. The equals, hashCode, and toString methods, as well as the private, final fields and public
   * constructor, are generated by the Java compiler. <br>
   * 3. Modifier 'static' is redundant for inner records <br>
   * 4.
   */
  private static record NewRecord(int number, String name) {}

  /**
   * While a public constructor is generated for us, we can still customize our constructor
   * implementation. This customization is intended to be used for validation and should be kept as
   * simple as possible. <br>
   * <br>
   * 1. Non-canonical record constructor must delegate to another constructor <br>
   * 2.
   */
  private record RecordDefaultConstructors(int num, String str, Object obj) {

    public RecordDefaultConstructors {
      Objects.requireNonNull(str);
      Objects.requireNonNull(obj);
    }
  }

  private record RecordAllArgsConstructors(int num, String str, Object obj) {

    /**
     * Redundant canonical constructor <br>
     * Remove this redundant constructor which is the same as a default one.
     */
    public RecordAllArgsConstructors(int num, String str, Object obj) {
      this.num = num;
      this.str = str;
      this.obj = obj;
    }
  }

  private record RecordDefaultFiledValue(int num, String address) {
    public RecordDefaultFiledValue(int num) {
      this(num, "Unknown");
    }
  }
}