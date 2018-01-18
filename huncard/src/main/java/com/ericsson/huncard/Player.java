package com.ericsson.huncard;

import java.util.Arrays;

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
		Card[] result = Arrays.copyOfRange(this.cards, 0, this.index);
		this.index = 0;
		return result;
	}

	public int getScore() {
		int result = 0;
		for (int i = 0; i < this.index; i++) {
			result += this.cards[i].getValue();
		}
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder content = new StringBuilder(100);
		content.append("---[ ").append(this.name).append(" ]--- ").append(" Score: ").append(this.getScore()).append("\n");
		for (int i = 0; i < this.index; i++) {
			content.append("[").append(i + 1).append("] ").append(this.cards[i]).append("\n");
		}
		return content.toString();
	}

}
