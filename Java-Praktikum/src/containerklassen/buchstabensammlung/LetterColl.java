package containerklassen.buchstabensammlung;

public class LetterColl {

	private char[] list;
    private final int[] lettercount;

    private final int letters;
    private final static char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final static char FIRST = ALPHABET[0];
    private final static int N = ALPHABET.length;	
    
    public LetterColl(final char... ls) {
        lettercount = new int[N];
        letters = ls.length;
        for(final char c : ls){        	
        	lettercount[c - FIRST]++;
        }
    }
	
	public LetterColl(String s){
		this(s.toCharArray());
	}
	
	public int count(char c){
		int count = 0;
		for(int i=0; i<list.length; i++){
			if(list[i] == c){
				count++;
			}
		}
		return count;
	}
	
	public int size(){
		return list.length;
	}
	

	
	public static void main(String[] args) {

		LetterColl lc = new LetterColl('A', 'B', 'C', 'A');
		LetterColl lc2 = new LetterColl("ALLDRFESLLLLLLF");
		System.out.println(lc2.count('L'));
	}

}
