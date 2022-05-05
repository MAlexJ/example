package com.malex.lecture_24_encryption.AES;

import lombok.extern.java.Log;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import static junit.framework.TestCase.assertNotNull;

/**
 * Encode AES in JAVA
 * Decode in JS by crypto-js
 * <p>
 * solution: https://stackoverflow.com/questions/69094658/how-to-implement-cryptojs-aes-encrypt-function-in-java
 * <p>
 * JS:
 * src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/crypto-js.js"
 * Html scripts:
 * var encryptedAES = CryptoJS.AES.encrypt("Message", "Erf4yhThu3okhUy8");
 * var decryptedBytes = CryptoJS.AES.decrypt("U2FsdGVkX1+z7vhpdtpIrwvLmYArDEI75LbPpPegZlj1kYvHxxZe6lFX+YlYseP+", "Erf4yhThu3okhUy8");
 * .........................
 */
@Log
public class AesEncodeInJavaAndDecodeInJS {

    private static final String ALG_TYPE = "AES";
    private static final String ALG_MODE = "CBC";
    private static final String ALG_PAD = "PKCS5Padding";

    private static final String ALG_TEMPLATE = "%s/%s/%s";

    @Test
    public void test2() {
        // given
        String stringToEncrypt = "Hello world 12345";
        String secret = "Erf4yhThu3okhUy8";

        // when
        String encryptData = encrypt(stringToEncrypt, secret);
        log.info(encryptData);

        // then
        assertNotNull(encryptData);
    }

    public static String encrypt(String stringToEncrypt, String secret) {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[8];
        sr.nextBytes(salt);

        final byte[][] keyAndIV = generateKeyAndIV(32, 16, 1, salt, secret.getBytes(StandardCharsets.UTF_8), getMd5());
        byte[] encryptedData = getBytesFormCipher(stringToEncrypt, keyAndIV);
        byte[] prefixAndSaltAndEncryptedData = new byte[16 + encryptedData.length];

        // Copy prefix (0-th to 7-th bytes)
        System.arraycopy("Salted__".getBytes(StandardCharsets.UTF_8), 0, prefixAndSaltAndEncryptedData, 0, 8);
        // Copy salt (8-th to 15-th bytes)
        System.arraycopy(salt, 0, prefixAndSaltAndEncryptedData, 8, 8);
        // Copy encrypted data (16-th byte and onwards)
        System.arraycopy(encryptedData, 0, prefixAndSaltAndEncryptedData, 16, encryptedData.length);
        return Base64.getEncoder().encodeToString(prefixAndSaltAndEncryptedData);
    }

    private static MessageDigest getMd5() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static byte[] getBytesFormCipher(String stringToEncrypt, byte[][] keyAndIV) {
        try {
            // 1. verification
            verificationKeyAndIV(keyAndIV);

            // 2. create KEY + IV setting
            IvParameterSpec ivParameterSpec = new IvParameterSpec(keyAndIV[1]);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyAndIV[0], ALG_TYPE);

            // 3. init Cipher
            Cipher cipher = Cipher.getInstance(String.format(ALG_TEMPLATE, ALG_TYPE, ALG_MODE, ALG_PAD));
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(stringToEncrypt.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void verificationKeyAndIV(byte[][] keyAndIV) {
        if (keyAndIV == null) {
            throw new IllegalArgumentException();
        }
        if (keyAndIV[0] == null) {
            throw new IllegalArgumentException();
        }
        if (keyAndIV[1] == null) {
            throw new IllegalArgumentException();
        }
    }

    public static byte[][] generateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password, MessageDigest md) {

        int digestLength = md.getDigestLength();
        int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
        byte[] generatedData = new byte[requiredLength];
        int generatedLength = 0;

        try {
            md.reset();

            // Repeat process until sufficient data has been generated
            while (generatedLength < keyLength + ivLength) {

                // Digest data (last digest if available, password data, salt if available)
                if (generatedLength > 0) md.update(generatedData, generatedLength - digestLength, digestLength);
                md.update(password);
                if (salt != null) md.update(salt, 0, 8);
                md.digest(generatedData, generatedLength, digestLength);

                // additional rounds
                for (int i = 1; i < iterations; i++) {
                    md.update(generatedData, generatedLength, digestLength);
                    md.digest(generatedData, generatedLength, digestLength);
                }

                generatedLength += digestLength;
            }

            // Copy key and IV into separate byte arrays
            byte[][] result = new byte[2][];
            result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
            if (ivLength > 0) result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);

            return result;

        } catch (DigestException e) {
            throw new IllegalArgumentException(e);

        } finally {
            // Clean out temporary data
            Arrays.fill(generatedData, (byte) 0);
        }
    }
}
