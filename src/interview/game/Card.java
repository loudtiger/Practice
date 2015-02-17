package interview.game;

public class Card {

	private Suit suit;
	private CardValue value;
	
	public Card(Suit suit, CardValue value) {
		this.suit = suit;
		this.value = value;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value.getValue();
	}
	
	public String toString() {
		return value.toString() + " of " + suit.toString();
	}
}