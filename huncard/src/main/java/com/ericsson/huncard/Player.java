package com.ericsson.huncard;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private final String name;
	private final List<Card> cards;

	public Player(String name) {
		this.name = name;
		this.cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public Card[] dropCards() {
		final Card[] result = this.cards.stream().toArray(Card[]::new);
		this.cards.clear();
		return result;
	}

	public int getScore() {
		int result = 0;
		for (final Card card : this.cards) {
			result += card.getValue();
		}
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder content = new StringBuilder(100);
		content.append("---[ ").append(this.name).append(" ]--- ").append(" Score: ").append(this.getScore()).append("\n");
		for (int i = 0; i < this.cards.size(); i++) {
			content.append("[").append(i + 1).append("] ").append(this.cards.get(i)).append("\n");
		}
		return content.toString();
	}

}
