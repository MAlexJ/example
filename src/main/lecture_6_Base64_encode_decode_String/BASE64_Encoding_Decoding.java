import org.junit.Test;

import java.util.Base64;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;

/**
 * BASE64 Encoding and Decoding.
 */
public class BASE64_Encoding_Decoding {

	public static void main(String[] args) {

		String srt = "wewrrw";

		// encode without padding
		String encoded = Base64.getEncoder().withoutPadding().encodeToString(srt.getBytes());

		System.out.println("encoded: " + encoded);

		// decode a String
		byte[] barr = Base64.getDecoder().decode(encoded);

		System.out.println("decode: " + new String(barr));

	}


	/**
	 * Encode String without padding
	 *
	 * @param str the URL for encoding
	 * @return encoding URL
	 */
	private String encode(String str) {

		if (str == null) {
			throw new RuntimeException("Incoming string is null!");
		}

		byte[] bytes = str.getBytes();

		return Base64.getEncoder()
				  .withoutPadding()
				  .encodeToString(bytes);

	}

	/**
	 * Decode a String
	 *
	 * @param str encoding URL
	 * @return decoding URL
	 */
	private String decode(String str) {

		byte[] barr = Base64.getDecoder().decode(str);

		return new String(barr);
	}

	private void testEncodiggDecoding(String srt) {

		String encode = encode(srt);

		String decode = decode(encode);

		assertEquals(srt, decode);
	}

	@Test
	public void test() {

		testEncodiggDecoding("11412425ycj0329c70920rp?>?/!@#$%^&*()))+_AKODOAO");
		testEncodiggDecoding("+_-0(1235467890-0()}|{}[]`~");
		testEncodiggDecoding("/passwors/email?=asfkhkjkjfsjk&^76");
		testEncodiggDecoding(UUID.randomUUID().toString());
		testEncodiggDecoding(UUID.randomUUID().toString());
		testEncodiggDecoding(UUID.randomUUID().toString());
		testEncodiggDecoding(UUID.randomUUID().toString());
		testEncodiggDecoding(UUID.randomUUID().toString());
		testEncodiggDecoding(UUID.randomUUID().toString());
		testEncodiggDecoding(UUID.randomUUID().toString());
		testEncodiggDecoding(UUID.randomUUID().toString());

	}


}
