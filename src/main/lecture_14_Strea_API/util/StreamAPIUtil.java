package util;

/**
 * Print log-message to console
 */
public class StreamAPIUtil {

    /**
     * Print log
     */
    public static void print(String... srt) {

        StringBuilder sb = new StringBuilder("<<<<<<<<<<<< ");
        if (srt.length > 0) {
            sb.append(srt[0]);
        }

        sb.append(" >>>>>>>>>>>> ");

        if (srt.length == 0) {
            sb.append("\n");
        }

        System.out.println(new String(sb));
    }
}
