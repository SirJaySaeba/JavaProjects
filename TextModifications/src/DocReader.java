import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class DocReader {

	private String path;
	
	public DocReader(String path){
		this.path = path;
	}
	
	public String[] openFile() throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader textreader = new BufferedReader(fr);
		
		final int lines = 3;
		String[] textData = new String[lines];
		
		for(int i = 0; i <= lines;i++){
			textData[i] = textreader.readLine();
		}
		textreader.close();
		return textData;
	}
}
