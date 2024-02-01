package com.malex.lecture_5_String.base.example_18_add_and_remove_first_symbol;

import lombok.extern.java.Log;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by malex on 15.07.16.
 */
@Log
public class AddAndRemoveFirstSymbol {

    @Test
    public void simpleTest() {
        replaceString();
        log.info(replaceCharAt("oiu88y", 4, 'w'));
    }

    // Чтобы заменить все вхождения данного символа:
    private void replaceString() {
        String myString = "Replace ' by * ";
        String tmpString = myString.replace('\'', '*');
        log.info("Original = " + myString);
        log.info("Result   = " + tmpString);
    }

    /**
     * replace character at specified position
     */
    private String replaceCharAt(String s, int pos, char c) {
        return s.substring(0, pos) + c + s.substring(pos + 1);
    }

    /**
     * remove character
     */
    private String removeChar(String s, char c) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) r += s.charAt(i);
        }
        return r;
    }

    /**
     * remove character at specified position
     */
    private String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

}