import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MapMerging {

	public static void main(String[] args) {

		List<String> list1 = addDummies("abc");
		List<String> list2 = addDummies("xyz");
		List<String> list3 = addDummies("bla");
		List<String> list4 = addDummies("snu");

		
		Map<String,List<String>> map1 = new HashMap<>();
		Map<String,List<String>> map2 = new HashMap<>();
		Map<String,List<String>> consMap = new HashMap<>();
		
		map1.put("id1", list1);
		map1.put("id2", list1);
		map1.put("id3", list1);
		map2.put("id1", list2);
		map2.put("id2", list3);
		map2.put("id4", list4);
		
		consMap.putAll(map1);
		
		//for(Map.Entry<String, List<String>> entry : map1.entrySet()){}
		System.out.println(map2.get("id2"));
		
		for(String key : map2.keySet()){
			if(consMap.containsKey(key)){
				consMap.get(key).addAll(map2.get(key));
			}else{
		        consMap.put(key,map2.get(key));
			}
		}
		
		System.out.println(consMap);
	
	}

	private static List<String> addDummies(String bla){
		List<String> list = new ArrayList<>();
		for(int i = 0; i<2; i++){
			list.add(bla+i);
		}
		return list;
	}
	
}
