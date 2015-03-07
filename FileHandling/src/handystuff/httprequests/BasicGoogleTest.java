package handystuff.httprequests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class BasicGoogleTest {

	public static void main(String[] args) {
	      String url="http://www.stereogum.com/page/2/?s=albums+From+Worst+To+Best";
	      String charset="UTF-8";
	      String key="";
	      try{
		      String query = String.format("%s",URLEncoder.encode(key, charset));
		      URLConnection con = new URL(url+ query).openConnection();
		      //con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		      String inputLine ;
		      
		      while ((inputLine = in.readLine())!= null ){		    	  
		    	  if(inputLine.contains("albums-from-worst-to-best")){		    		  
		    		  System.out.println(inputLine);
		    		  System.out.println();
		    	  }
		      }
		      in.close(); 
	      }catch(Exception e){
	    	  System.out.println("bla");
	      }

	}

}
