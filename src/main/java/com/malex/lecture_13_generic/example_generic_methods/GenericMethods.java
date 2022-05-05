package com.malex.lecture_13_generic.example_generic_methods;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
public class GenericMethods {
  public static void main(String[] args) {
    Pair<Integer, String> p1 = new Pair<>(1, "apple");
    Pair<Integer, String> p2 = new Pair<>(2, "pear");

    boolean same = Util.<Integer, String>compare(p1, p2);
    log.info("Compare: " + same);
  }
}

@Getter
@Setter
@RequiredArgsConstructor
class Pair<K, V> {

  @NonNull private K key;

  @NonNull private V value;
}

class Util {

  private Util() {
    throw new UnsupportedOperationException();
  }

  public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
    return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
  }
}
