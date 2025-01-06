package com.malex.lecture_6_Base64;

import static junit.framework.TestCase.assertEquals;

import java.util.Base64;
import java.util.Objects;
import java.util.UUID;
import lombok.extern.java.Log;
import org.junit.Test;

/**
 * BASE64 Encoding and Decoding. This class consists sample of Base64 methods for obtaining encoders
 * and decoders for the Base64 encoding scheme.
 */
@Log
public class EncodingDecodingBase64Sample {

  private static final String ERROR_MESSAGE = "Incoming string is null!";

  @Test
  public void simpleTest() {
    String srt = "test simple string!";

    // encode without padding
    String encoded = Base64.getEncoder().withoutPadding().encodeToString(srt.getBytes());

    log.info("encoded: " + encoded);

    // decode a String
    byte[] barr = Base64.getDecoder().decode(encoded);

    log.info("decode: " + new String(barr));

    // test
    assertEquals(srt, new String(barr));
  }

  /**
   * Encode String without padding
   *
   * @param str the URL for encoding
   * @return encoding URL
   */
  private String encode(String str) {
    Objects.requireNonNull(str, ERROR_MESSAGE);
    byte[] bytes = str.getBytes();
    return Base64.getEncoder().withoutPadding().encodeToString(bytes);
  }

  /**
   * Decode a String
   *
   * @param str encoding URL
   * @return decoding URL
   */
  private String decode(String str) {
    Objects.requireNonNull(str, ERROR_MESSAGE);
    byte[] barr = Base64.getDecoder().decode(str);
    return new String(barr);
  }

  @Test
  public void test() {
    testEncodingDecoding("11412425ycj0329c70920rp?>?/!@#$%^&*()))+_AKODOAO");
    testEncodingDecoding("+_-0(1235467890-0()}|{}[]`~");
    testEncodingDecoding("/passwors/email?=asfkhkjkjfsjk&^76");
    testEncodingDecoding(UUID.randomUUID().toString());
    testEncodingDecoding(UUID.randomUUID().toString());
    testEncodingDecoding(UUID.randomUUID().toString());
    testEncodingDecoding(UUID.randomUUID().toString());
    testEncodingDecoding(UUID.randomUUID().toString());
    testEncodingDecoding(UUID.randomUUID().toString());
    testEncodingDecoding(UUID.randomUUID().toString());
    testEncodingDecoding(UUID.randomUUID().toString());
  }

  private void testEncodingDecoding(String srt) {
    String encode = encode(srt);
    String decode = decode(encode);
    assertEquals(srt, decode);
  }
}
