package handystuff.httprequests;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;
 
public class HttpURLConnectionExample {

	public static void main(String[] args) throws Exception {
		
		String urlString = "http://www.stereogum.com/page/1/?s=albums+From+Worst+To+Best";
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		
		System.out.println(is.available());
		
//	    String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
//	    String google2 = "http://www.google.de/search?ie=utf-8&oe=utf-8&gws_rd=cr&ei=QPyuVIbNNsKvU_SGgeAN&q=";
//	    String search = "stereogum albums from worst to best";
//	    String charset = "UTF-8";
//
//	    URL url = new URL(google2 + URLEncoder.encode(search, charset));
//	    Reader reader = new InputStreamReader(url.openStream(), charset);
//	    WebPageResults results = new Gson().fromJson(reader, WebPageResults.class);
//
//	    // Show title and URL of 1st result.
//	    for(int i=0; i<results.getResponseData().getResults().size();i++){	    	
//	    	System.out.println(results.getResponseData().getResults().get(i).getTitle());
//	    	//System.out.println(results.getResponseData().getResults().get(i).getUrl());
//	    }
	}
}
