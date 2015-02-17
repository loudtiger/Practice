package interview.game;

enum CardValue {
	KING(13),
	QUEEN(12),
	JACK(11),
	TEN(10),
	NINE(9),
	EIGHT(8),
	SEVEN(7),
	SIX(6),
	FIVE(5),
	FOUR(4),
	THREE(3),
	TWO(2),
	ACE(1);
	
	private int value;
	
	private CardValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public String toString() {
		String valueConstant = this.name();
		return valueConstant.toLowerCase();
	}
}