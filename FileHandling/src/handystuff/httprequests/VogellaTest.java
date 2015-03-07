package handystuff.httprequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class VogellaTest {

	public static void main(String[] args) throws IOException {
		String s = "from+worst+to+best";
		TinyUrl tiny = new TinyUrl();
		System.out.println(tiny.shorter(s));
	}
}
