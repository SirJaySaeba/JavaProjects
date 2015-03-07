public class Palindrom {

	public static void main(String[] arg0){
		String text = "Otto is driving a racecar with Anna on Level 7";
		
		String [] words = text.split(" ");
		int counter = 0;

		for(String word : words){			
			
			if(word.length() < 2){
				continue;
			}
			
			String reversedWord = "";
			
			for(int i = word.length()-1; i >=0 ; i--){
				reversedWord = reversedWord.concat(String.valueOf(word.charAt(i))).toLowerCase();
			}
			
			if(word.toLowerCase().equals(reversedWord)){
				counter++;
				System.out.println(word);
			}
		}
		System.out.println("There are "+counter+" palindromes!");
	}
	
}
