import java.io.BufferedReader;
import java.io.FileReader;


public class TextFile {

	public static void main(String[] args) {
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader("C:/Users/Sir Jay/Documents/JavaTest/test.txt"));
	    	
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	        System.out.println(everything);
	        br.close();
	    } catch(Exception e){
	    	e.printStackTrace();
	    }

	}

}
