package interfaces.spielkarten;

import java.util.EnumMap;

public class Hand {
	
	public final static int HAND_CARDS = 5;

	private final EnumMap<Kind, Integer> byKind = new EnumMap<>(Kind.class);
	private final EnumMap<Suit, Integer> bySuit = new EnumMap<>(Suit.class);
	
	private Rank rank;
	private int longestRun = 0;
	
	public EnumMap<Kind, Integer> getByKind() {
		return byKind;
	}

	public EnumMap<Suit, Integer> getBySuit() {
		return bySuit;
	}

	public int getLongestRun() {
		return longestRun;
	}

	public Hand(Card...cards) {
		if(cards.length != HAND_CARDS){
			throw new IllegalArgumentException("wrong number of cards");
		}
		for(Kind k: Kind.values()){
			byKind.put(k, 0);
		}
		for(Card c: cards){
			byKind.put(c.getKind(), byKind.get(c.getKind())+1);
		}
		
		for(Suit s: Suit.values()){
			bySuit.put(s, 0);
		}
		for(Card c: cards){
			bySuit.put(c.getSuit(), bySuit.get(c.getSuit())+1);
		}

		int run = 0;
		
		for(int i : byKind.values()){
			if(i==0){
				run = 0;
			}else{
				run++;
			}
			
//			if(byKind.get(Kind.A)>0){
//				run++;
//			}
			
			if(run > longestRun){
				longestRun = run;				
			}
		
		}
		
		for(Rank r: Rank.values()){
			if(r.matches(this)){
				rank = r;
			}
		}
		
	}
	
	public Rank rank(){
		return rank;
	}
	
	
}
