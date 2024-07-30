package com.malex.lecture_5_String.base.task_07_copyValueOf;

import lombok.extern.java.Log;
import org.junit.Test;

import com.malex.utils.AbstractUtils;

/**
 * Created by Alex on 06.03.2015.
 */
public class StringCopyValueOf  extends AbstractUtils {

    @Test
    public void test() {
        char[] str1 = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
        String str2 = "";

        //This method returns a String that contains the characters of the character array.
        str2 = str2.copyValueOf(str1);
        print("Returned String: " + str2);

        //This method returns a String that contains the characters of the character array.
        str2 = str2.copyValueOf(str1, 2, 6);
        print("Returned String: " + str2);
    }
}
