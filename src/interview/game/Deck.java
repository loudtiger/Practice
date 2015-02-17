package interview.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
		for(Suit s : Suit.values()) {
			for(CardValue v : CardValue.values()) {
				cards.add(new Card(s, v));
			}
		}
	}
	
	public int getNumValidCards() {
		return cards.size();
	}
	
	public Card peekTopCard() {
		return cards.get(0);
	}
	
	public Card drawTopCard() {
		Card c = cards.get(0);
		remove(c);
		return c;
	}
	
	public int replaceOnTop(Card c) {
		cards.add(0, c);
		return cards.size();
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public int remove(Card c) {
		cards.remove(c);
		return cards.size();
	}
}
