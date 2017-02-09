package example_02;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * @author malex
 *         Link: http://stackoverflow.com/questions/1116123/how-do-i-calculate-someones-age-in-java
 */
public class CalculateAgeFromDate {

   public static void main(String[] args) {

      System.out.println(calculateAge("01/03/1985"));

   }


   private static int calculateAge(String date) {

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      LocalDate birthDate = LocalDate.parse(date, formatter);

      // current date
      LocalDate now = LocalDate.now();
      // calculate
      if ((birthDate != null)) {
         return Period.between(birthDate, now).getYears();
      } else {
         return 0;
      }
   }

}
