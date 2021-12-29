package com.malex.lecture_24_encryption.AES;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import static junit.framework.TestCase.assertEquals;

/**
 * Encryption and Decryption
 * <p>
 * To implement input string encryption, we first need to generate the secret key and IV according to the previous section.
 * As the next step, we create an instance from the Cipher class by using the getInstance() method.
 * <p>
 * Additionally, we configure a cipher instance using the init() method with a secret key, IV, and encryption mode.
 * Finally, we encrypt the input string by invoking the doFinal() method.
 */
@Log4j
public class AdvancedEncryptionStandard {

    private static final String ALG_TYPE = "AES";
    private static final String ALG_MODE = "CBC";
    private static final String ALG_PAD = "PKCS5Padding";

    private static final String ALG_TEMPLATE = "%s/%s/%s";


    @Test
    public void givenPasswordWhenEncryptThenSuccess() {
        // given: text or secret for encoding/decoding
        String plainText = "www.baeldung.com or secret key";

        // and: password and salt
        String password = "Paws!123";
        String salt = "12345678";

        // and: generate IV
        IvParameterSpec ivParameterSpec = generateIv();

        // and: generate secret key
        SecretKey key = getKeyFromPassword(password, salt);

        // when:
        String cipherText = encryptPasswordBased(plainText, key, ivParameterSpec);

        // and:
        String decryptedCipherText = decryptPasswordBased(cipherText, key, ivParameterSpec);

        // then:
        assertEquals(plainText, decryptedCipherText);
    }

    public static String encryptPasswordBased(String plainText, SecretKey key, IvParameterSpec iv) {
        try {
            Cipher cipher = Cipher.getInstance(String.format(ALG_TEMPLATE, ALG_TYPE, ALG_MODE, ALG_PAD));
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String decryptPasswordBased(String cipherText, SecretKey key, IvParameterSpec iv) {
        try {
            String template = String.format(ALG_TEMPLATE, ALG_TYPE, ALG_MODE, ALG_PAD);
            Cipher cipher = Cipher.getInstance(template);
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] decode = Base64.getDecoder().decode(cipherText);
            byte[] bytes = cipher.doFinal(decode);
            return new String(bytes);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Initialization Vector (IV)
     * IV is a pseudo-random value and has the same size as the block that is encrypted.
     * We can use the SecureRandom class to generate a random IV.
     *
     * @return IV
     */
    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    /**
     * In the second approach, the AES secret key can be derived from a given password using a password-based key
     * derivation function like PBKDF2.
     * We also need a salt value for turning a password into a secret key.
     * The salt is also a random value.
     *
     * @param password -  password into a secret key.
     * @param salt     - salt is also a random value.
     */
    public static SecretKey getKeyFromPassword(String password, String salt) {
        try {
            // We can use the SecretKeyFactory class with the PBKDF2WithHmacSHA256 algorithm for generating a key from a given password
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            // Let’s define a method for generating the AES key from a given password with 65,536 iterations and a key length of 256 bits:
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
            return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * @param keySize must be equal to 128, 192 or 256
     * @return secret key for AES
     */
    public static SecretKey generateKey(int keySize) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(keySize);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Test
    public void testSecretKey() {
        SecretKey secretKey = generateKey(128);
        byte[] encoded = secretKey.getEncoded();
        assertEquals(encoded.length, 16);
    }
}
