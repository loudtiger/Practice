package interview.game;

enum Suit {
	SPADES("black"),
	HEARTS("red"),
	CLUBS("black"),
	DIAMONDS("red");
	
	private String color;
	
	private Suit(String color) {
		this.color = color;
	}
	
	public String toString() {
		String suitConstant = this.name();
		return suitConstant.toLowerCase();
	}
	
	public String getColor() {
		return color;
	}
}