package interfaces.chiffren;

public interface Cipher {

	String encrypt(String plainText, int key);
	String decrypt(String cryptText, int key);
}
