package interfaces.spielkarten;

public class PokerApp {

	public static void main(String[] args) {

		Hand h = new Hand(new Card(Suit.Heart,Kind.A),
							new Card(Suit.Heart,Kind.A),
							new Card(Suit.Diamond,Kind.A),
							new Card(Suit.Heart,Kind.K),
							new Card(Suit.Heart,Kind.K));
		
		System.out.println(h.rank());
		
	}

}
