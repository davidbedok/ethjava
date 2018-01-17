package com.ericsson.huncard;

public class Player {

	public static final int NUMBER_OF_PLAYER_CARDS = 3;
	private final String name;
	private final Card[] cards;
	private int index;

	public Player(String name) {
		this.name = name;
		this.cards = new Card[NUMBER_OF_PLAYER_CARDS];
		this.index = 0;
	}

	public void addCard(Card card) {
		this.cards[this.index++] = card;
	}

	public Card[] dropCards() {
		this.index = 0;
		return this.cards;
	}

	public int getScore() {
		int result = 0;
		for (int i = 0; i < this.cards.length; i++) {
			result += this.cards[i].getValue();
		}
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder content = new StringBuilder(100);
		content.append("Player: ").append(this.name).append(" Score: ").append(this.getScore()).append("\n");
		for (final Card card : this.cards) {
			content.append(card).append("\n");
		}
		return content.toString();
	}

}
