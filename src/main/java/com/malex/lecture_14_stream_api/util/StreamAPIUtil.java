package com.malex.lecture_14_stream_api.util;

import lombok.extern.log4j.Log4j;

/**
 * Print log-message to console
 */

@Log4j
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
        log.info(new String(sb));
    }
}
