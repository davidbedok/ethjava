package com.ericsson.huncard;

public enum CardSuit {

	Acorns(1, "Makk"),
	Bells(2, "Tok"),
	Leaves(3, "Zold"),
	Hearts(4, "Piros");

	private final int value;
	private final String label;

	private CardSuit(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public int getValue() {
		return this.value;
	}

	// public static CardSuit fromValue(int value) {
	// CardSuit ret = CardSuit.getDefault();
	// CardSuit[] cardSuits = CardSuit.values();
	// int i = 0;
	// while ((i < cardSuits.length) && (cardSuits[i].getValue() != value)) {
	// i++;
	// }
	// if (i < cardSuits.length) {
	// ret = cardSuits[i];
	// }
	// return ret;
	// }

	// public static CardSuit getDefault() {
	// return CardSuit.Acorns;
	// }

	@Override
	public String toString() {
		return this.label;
	}

}
