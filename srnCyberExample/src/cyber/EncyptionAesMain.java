package cyber;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class EncyptionAesMain {
	private final int AESKEYLENGTH = 256;
	private final String SALT = "bla";
	private void doMain(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		EncryptionAes aes = new EncryptionAes();
		SecretKey key = aes.generateKey(AESKEYLENGTH);
		System.out.format("Key with n = %d:\n", AESKEYLENGTH);
		
		for(Byte my : key.getEncoded()) {
			System.out.println(String.format("0x%02X", my));
		}
		
		SecretKey secretKeyFromPassword = aes.getKeyFromPassword("1234", SALT);
		System.out.format("key with password and salt = %s\n", SALT);
		for(Byte my : secretKeyFromPassword.getEncoded()) {
			System.out.println(String.format("0x%02X", my));
		}
		
		IvParameterSpec parameterSpec = aes.getInitVector();
		
		System.out.format("Random generated init vector:\n");

		for(Byte my : parameterSpec.getIV()) {
			System.out.println(String.format("0x%02X", my));
		}
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
			EncyptionAesMain aesMain = new EncyptionAesMain();
			aesMain.doMain(args);
	}

}
