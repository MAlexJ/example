package com.malex.lecture_24_javaFX;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.util.HashMap;
import java.util.Map;

public class App {
    private static Map<KeyCombination, String> map = new HashMap<>();

    private static String A = "a";
    private static String B = "b";
    private static String C = "c";
    private static String D = "d";

    static {
        map.put(new KeyCodeCombination(KeyCode.A, KeyCombination.SHIFT_ANY), A);
        map.put(new KeyCodeCombination(KeyCode.B, KeyCombination.SHIFT_ANY), B);
        map.put(new KeyCodeCombination(KeyCode.C, KeyCombination.SHORTCUT_ANY), C);
    }

    public static void main(String[] args) {
        for (KeyCombination combination: map.keySet()){
            if(combination.getShortcut()!= null){
                System.out.println(map.get(combination));
            }
        }
    }
}
