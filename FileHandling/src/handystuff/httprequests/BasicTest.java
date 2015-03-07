package handystuff.httprequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BasicTest {

	public static void main(String[] args) {
		try {
	        URL oracle = new URL("http://www.oracle.com/");
	        URLConnection yc = oracle.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	        String inputLine;
	        while ((inputLine = in.readLine()) != null){	        	
	        	System.out.println(inputLine);
	        }
	        in.close();
		} 
		catch (MalformedURLException e) { 
		    // new URL() failed
		    // ...
		} 
		catch (IOException e) {   
		    // openConnection() failed
		    // ...
		}
		
	}

}
