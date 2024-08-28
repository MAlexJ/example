package com.malex.lecture_12_serialization.utils;

import com.malex.utils.SampleException;
import java.io.*;

public class SerializationDeserializationUtils {

  private SerializationDeserializationUtils() {
    // none
  }

  public static <T> void serialization(File file, T obj) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
      out.writeObject(obj);
    } catch (IOException e) {
      throw new SampleException(e);
    }
  }

  public static <T> T deserialization(File file, Class<T> clazz) {
    try (ObjectInput in = new ObjectInputStream(new FileInputStream(file))) {
      return clazz.cast(in.readObject());
    } catch (IOException | ClassNotFoundException e) {
      throw new SampleException(e);
    }
  }
}
