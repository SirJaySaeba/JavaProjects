import java.util.ArrayList;
import java.util.List;


public class Seperator {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		list.add("ding1");
		list.add("ding2");
		list.add("ding3");
		list.add("ding4");
		list.add("ding5");
		
		for(String item : list){
			sb.append(item);
			
			if(list.indexOf(item) != list.size()-1){				
				sb.append(", ");
			}
		}
		System.out.println(sb);
	}

}
