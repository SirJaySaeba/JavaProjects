package handystuff.httprequests;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class TinyUrl  {
  private static final String tinyUrl = "http://www.stereogum.com/?cat=3272&s=";
  
  public String shorter(String url) throws IOException {
    String tinyUrlLookup = tinyUrl + url;
    BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(tinyUrlLookup).openStream()));
    String tinyUrl = reader.readLine();
    return tinyUrl;
  }
  
  
  
}