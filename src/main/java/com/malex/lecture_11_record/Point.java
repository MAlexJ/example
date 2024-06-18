package com.malex.lecture_11_record;

/**
 * Extends not allowed for record 1
 * <li>1. go to class folder: cd /src/main/java/com/malex/lecture_11_record
 * <li>2. run cmd: javac --enable-preview -source 21 Point.java <br>
 *     <br>
 *     With the help of javap, you can can have details about the code generate for Point:
 * <li>3. run cmd: javap -p Point javac --enable-preview -source 14
 *     com.malex.lecture_11_record.Point.java
 */

// record is class that support extends java.lang.Record
// info:
// https://stackoverflow.com/questions/63605794/is-there-any-way-of-using-records-with-inheritance
public record Point(double x, double y) {
  /**
   * Compiled from "Point.java"
   *
   * <pre>
   * Compiled from "Point.java"
   * public final class Point extends java.lang.Record {
   *   private final double x;
   *   private final double y;
   *   public Point(double, double);
   *   public java.lang.String toString();
   *   public final int hashCode();
   *   public final boolean equals(java.lang.Object);
   *   public double x();
   *   public double y();
   * }
   * </pre>
   */

  // record is final class !!
  // private static class DPoint extends Point{ }
}
