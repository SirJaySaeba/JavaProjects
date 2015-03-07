package interfaces.chiffren;

public class ChiffreMain {

	public static void main(String[] args) {

		String text = "a";
		byte[] bytes = text.getBytes();
		System.out.println(bytes);
		text = new String(bytes);
		System.out.println(text);
	}

}
