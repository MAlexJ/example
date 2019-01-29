package com.malex.lecture_12_Serialization.example.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import lombok.SneakyThrows;

public class SerializationUtils {

  private SerializationUtils() {
    throw new UnsupportedOperationException();
  }

  @SneakyThrows
  public static <T> void serialization(File file, T obj) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
      out.writeObject(obj);
    }
  }

  @SneakyThrows
  public static <T> T deserialization(File file, Class<T> clazz) {
    try (ObjectInput in = new ObjectInputStream(new FileInputStream(file))) {
      return clazz.cast(in.readObject());
    }
  }
}
