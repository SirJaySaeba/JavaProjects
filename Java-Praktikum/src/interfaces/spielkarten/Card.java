package interfaces.spielkarten;

public class Card {

	private final Suit suit;
	private final Kind kind;
	
	public Card(Suit suit, Kind kind) {
		this.suit = suit;
		this.kind = kind;
	}

	public Suit getSuit() {
		return suit;
	}

	public Kind getKind() {
		return kind;
	}
	
	
}
