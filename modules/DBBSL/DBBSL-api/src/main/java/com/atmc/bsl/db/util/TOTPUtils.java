/**
 * 
 */
package com.atmc.bsl.db.util;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.codec.binary.Base32;

/**
 * @author Basel A.Aziz
 * 
 */
public class TOTPUtils
{
	private static final int SECRET_SIZE = 10;

	private static final int PASS_CODE_LENGTH = 4;

	private static final int INTERVAL = 30;

	private static final int WINDOW = 30;

	private static final String CRYPTO = "HmacSHA1";

	private static final Random rand = new Random();

	public static String generateSecret()
	{

		// Allocating the buffer
		byte[] buffer = new byte[SECRET_SIZE];

		// Filling the buffer with random numbers.
		rand.nextBytes(buffer);

		// Getting the key and converting it to Base32
		Base32 codec = new Base32();
		byte[] secretKey = Arrays.copyOf(buffer, SECRET_SIZE);
		byte[] encodedKey = codec.encode(secretKey);
		return new String(encodedKey);
	}

	public static boolean checkCode(String secret, long code)
	{
		Base32 codec = new Base32();
		byte[] decodedKey = codec.decode(secret);

		// Window is used to check codes generated in the near past.
		// You can use this value to tune how far you're willing to go.
		int window = WINDOW;
		long currentInterval = getCurrentInterval();

		for (int i = -window; i <= window; ++i)
		{
			long hash = TOTP.generateTOTP(decodedKey, currentInterval + i, PASS_CODE_LENGTH, CRYPTO);

			if (hash == code) { return true; }
		}

		// The validation code is invalid.
		return false;
	}
	
	public static long generateTOTP(String secret)
	{
		Base32 codec = new Base32();
		byte[] decodedKey = codec.decode(secret);
		long currentInterval = getCurrentInterval();

		return TOTP.generateTOTP(decodedKey, currentInterval, PASS_CODE_LENGTH, CRYPTO);
	}
	

	private static long getCurrentInterval()
	{
		long currentTimeSeconds = System.currentTimeMillis() / 1000;
		return currentTimeSeconds / INTERVAL;
	}
}
