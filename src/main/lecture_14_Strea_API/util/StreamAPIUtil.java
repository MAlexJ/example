package util;

/**
 * Print log-message to console
 */
public class StreamAPIUtil {

   /**
    * Print log
    */
   public static void print(String... srts) {

      StringBuilder sb = new StringBuilder();
      sb.append("<<<<<<<<<<<< ");

      if (srts.length > 0) {
         sb.append(srts[0]);
      }

      sb.append(" >>>>>>>>>>>> ");

      if (srts.length == 0) {
         sb.append("\n");
      }

      System.out.println(sb.toString());
   }
}
