package handystuff.httprequests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.bouncycastle.crypto.StreamBlockCipher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class BasicTest {

	private static final int ANZAHL_NODES = 233;
	
	public static void main(String[] args) {
	StringBuilder wholeScript = new StringBuilder();
		for(int node = 1; node<=ANZAHL_NODES; node++){
			final String url = "http://www.imn.htwk-leipzig.de/~waldmann/edu/ss14/fop/folien/main/node"+node+".html";
			try {
		        URL currentNode = new URL(url);
		        URLConnection yc = currentNode.openConnection();
		        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		        String inputLine;
		        StringBuilder bigString = new StringBuilder();
		        while ((inputLine = in.readLine()) != null){
		        	bigString.append(inputLine);
		        }
				Document doc = Jsoup.parse(bigString.toString());
				
			    for (Element element : doc.select("*")) {

			        if (!element.hasText() && element.isBlock()) {
			            element.remove();
			        }

			    }
				doc.select("address").remove();
				doc.getElementsByClass("navigation").remove();
				doc.getElementsByClass("ChildLinks").remove();
				String bodyContent = getEscapedHTML(doc.select("body").html());
				wholeScript.append(bodyContent);
		        in.close();
	 
			} 
			catch (Exception e) {   
			    // openConnection() failed
			    // ...
			}
		}
		
		try{
	        //write in file
			 
			File file = new File("C:/Users/Sir Jay/Documents/javaOutput/unterlagen1.html");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(wholeScript.toString());
			bw.close();
		}catch(Exception e){
			
		}
		
	}
	private static String getEscapedHTML(String content){
		return content.replace("ä", "&auml;").replace("ö", "&ouml;").replace("ü", "&uuml;")
				.replace("Ä", "&Auml;").replace("Ö", "&Ouml;").replace("Ü", "&Uuml;")
				.replace("ß", "&szlig;").replace("≥",">=");
	}
}
