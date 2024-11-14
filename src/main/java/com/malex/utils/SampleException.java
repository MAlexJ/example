package com.malex.utils;

public class SampleException extends RuntimeException {

  public SampleException(Throwable cause) {
    super(cause);
  }

  public SampleException(String message) {
    super(message);
  }

  public SampleException(String message, Throwable cause) {
    super(message, cause);
  }
}
