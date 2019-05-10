package com.malex.lecture_25_Java_8.example_17_JoinString;

import lombok.extern.log4j.Log4j;

@Log4j
public class JoinString {

    /*
     * CharSequence delimiter, CharSequence... elements
     */
    public static void main(String[] args) {

        String join = String.join("/", "a", "b", "c", "d", "e", "f");
        log.info(join);

        join = String.join("=", "java", null);
        log.info(join);

        try {
            String java = String.join(null, "java", null);
            log.info(java);
        } catch (RuntimeException ex) {
            log.info("NPE : " + ex.getMessage());
        }
    }
}
