package algorithmen.mustervergleich;

public class Maske {
	
	public static boolean match(String mask, String string){

		if(mask.isEmpty()){
			return string.isEmpty();
		}
		if(string.isEmpty()){
			return false;
		}
		
		if(mask.charAt(0) == '?' || mask.charAt(0) == string.charAt(0)){
			System.out.println(mask.substring(1));
			
			return match(mask.substring(1),string.substring(1));
		}else{			
			return false;
		}
	}
	
	public static boolean supermatch(String mask, String string){
		if(mask.isEmpty()){
			return string.isEmpty();
		}
		
		if(mask.charAt(0) == string.charAt(0)){
		
			return supermatch(mask.substring(1), string.substring(1));
			
		}else if(mask.charAt(0) == '*'){

			return supermatch(mask, string.substring(1));
		}else{
			
			return false;
		}
	}
	
	public static void main(String[] args) {

		String mask = "*3*2*";
		String string = "9993112";

		System.out.println(supermatch(mask,string));
		
	}

}
