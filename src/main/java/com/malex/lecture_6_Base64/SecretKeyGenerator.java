package com.malex.lecture_6_Base64;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {

  public static void main(String[] args) {
    // Generate a random secret key
    String secretKey = generateRandomSecretKey();

    // Print the generated secret key
    System.out.println("Generated Secret Key: " + secretKey);
  }

  private static String generateRandomSecretKey() {
    // Generate a 256-bit (32-byte) random secret key
    byte[] secretKeyBytes = new byte[32];
    new SecureRandom().nextBytes(secretKeyBytes);

    // Encode the secret key bytes using Base64
    return Base64.getEncoder().encodeToString(secretKeyBytes);
  }
}
