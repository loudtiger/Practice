package interview.game;

public class GameRunner {

	public static void main(String[] args) {
		Deck standardDeck = new Deck();
		Card c = standardDeck.drawTopCard();
		System.out.println("After drawing a " + c.toString() + ", " +  standardDeck.getCards().size() + " remain.");
		standardDeck.replaceOnTop(c);
		System.out.println("Replacing " + c +". We have " + standardDeck.getCards().size() + ".");
		standardDeck.shuffle();
		System.out.println(standardDeck.drawTopCard().toString());
	}

}
