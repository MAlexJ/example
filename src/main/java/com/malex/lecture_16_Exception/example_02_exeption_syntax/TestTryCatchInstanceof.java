package com.malex.lecture_16_Exception.example_02_exeption_syntax;

import lombok.extern.java.Log;

/**
 * Created by Alex on 19.06.2015.
 */
@Log
public class TestTryCatchInstanceof {

    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) e;
                log.severe("This is RuntimeException " + re.toString());
            } else {
                log.severe("No RuntimeException???");
            }
        }
    }

}
