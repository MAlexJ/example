package com.malex.lecture_7_Date.example01;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import lombok.extern.java.Log;

/**
 * @author malex Link:
 *     http://stackoverflow.com/questions/1116123/how-do-i-calculate-someones-age-in-java
 */
@Log
public class CalculateAgeFromDate {

  private static final String PATTERN = "dd/MM/yyyy";

  public static void main(String[] args) {
    log.info("date: 01/03/1983, age:" + calculateAge("01/03/1983"));
    log.info("date: 21/06/1985, age:" + calculateAge("21/06/1985"));
  }

  private static int calculateAge(String date) {

    Objects.requireNonNull(date, "date");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
    LocalDate birthDate = LocalDate.parse(date, formatter);

    // current date
    LocalDate now = LocalDate.now();

    // calculate
    return Period.between(birthDate, now).getYears();
  }
}
