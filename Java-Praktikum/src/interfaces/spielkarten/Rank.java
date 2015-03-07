package interfaces.spielkarten;

public enum Rank {

	HighCard(new CardMatcher(){
		public boolean matches(Hand hand){
			return true;
		}
	}),
	OnePair(new CardMatcher(){
		public boolean matches(Hand hand){
			for(int i: hand.getByKind().values()){
				if(i==2){					
					return true;
				}
			}
			return false;
		}
	}),
	TwoPairs(new CardMatcher(){
		public boolean matches(Hand hand){
			int pairs = 0;
			for(int i: hand.getByKind().values()){
				if(i==2){					
					pairs++;
				}
				if(pairs==2){
					return true;
				}else{
					continue;
				}
			}
			return false;		
		}
	}),
	ThreeOfAKind(new CardMatcher(){
		public boolean matches(Hand hand){
			for(int i: hand.getByKind().values()){
				if(i==3){					
					return true;
				}
			}
			return false;		
		}
	}),
	Straight(new CardMatcher(){
		public boolean matches(Hand hand){
			return hand.getLongestRun() == 5;
		}
	}),
	Flush(new CardMatcher(){
		public boolean matches(Hand hand){
			for(int i: hand.getBySuit().values()){
				if(i==5){					
					return true;
				}
			}
			return false;
		}
	}),
	FullHouse(new CardMatcher(){
		public boolean matches(Hand hand){
			//return hand.rank() == Rank.ThreeOfAKind && hand.rank() == Rank.OnePair;
			return OnePair.cardMatcher.matches(hand) && ThreeOfAKind.cardMatcher.matches(hand);
		}
	}),
	FourOfAKind(new CardMatcher(){
		public boolean matches(Hand hand){
			for(int i: hand.getByKind().values()){
				if(i==4){					
					return true;
				}
			}
			return false;		
		}
	}),
	StraightFlush(new CardMatcher(){
		public boolean matches(Hand hand){
			return Straight.cardMatcher.equals(hand) && Flush.cardMatcher.equals(hand);
		}
	}),
	RoyalFlush(new CardMatcher(){
		public boolean matches(Hand hand){
			return StraightFlush.cardMatcher.equals(hand) && hand.getByKind().get(Kind.A)>0 && hand.getByKind().get(Kind.K)>0;
		}
	});
	
	private interface CardMatcher{
		boolean matches(Hand hand);
	}
	
	private final CardMatcher cardMatcher;
	
	boolean matches(Hand hand){
		return cardMatcher.matches(hand);
	}
	
	Rank(CardMatcher cm){
		cardMatcher = cm;
	}
	
}
