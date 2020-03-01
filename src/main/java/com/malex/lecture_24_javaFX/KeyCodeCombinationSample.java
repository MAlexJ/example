package com.malex.lecture_24_javaFX;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.Map;

@Log4j
public class KeyCodeCombinationSample {

    private static final String KEY_A = "a";
    private static final String KEY_B = "b";
    private static final String KEY_C = "c";

    private static Map<KeyCombination, String> map;

    static {
        map = new HashMap<>();
        map.put(new KeyCodeCombination(KeyCode.A, KeyCombination.SHIFT_ANY), KEY_A);
        map.put(new KeyCodeCombination(KeyCode.B, KeyCombination.SHIFT_ANY), KEY_B);
        map.put(new KeyCodeCombination(KeyCode.C, KeyCombination.SHORTCUT_ANY), KEY_C);
    }

    public static void main(String[] args) {
        map.keySet().stream()
                .filter(combination -> combination.getShortcut() != null)
                .map(combination -> map.get(combination))
                .forEach(log::info);
    }
}
