package com.ericsson.huncard;

import java.util.Random;

public class Deck {

	private static final int SHUFFLE_FACTOR = 100;
	private final Card[] cards;
	private int topCardIndex;
	private final Random random;

	public Deck(Random random) {
		this.random = random;
		final CardRank[] ranks = CardRank.values();
		final CardSuit[] suits = CardSuit.values();

		this.cards = new Card[suits.length * ranks.length];

		int index = 0;
		for (final CardSuit suit : suits) {
			for (final CardRank rank : ranks) {
				this.cards[index++] = new Card(suit, rank);
			}
		}
		this.topCardIndex = 0;
	}

	public Card getTopCard() {
		return this.cards[this.topCardIndex++];
	}

	public void shuffle() {
		final int size = this.cards.length;
		for (int i = 0; i < SHUFFLE_FACTOR; i++) {
			this.changeCards(this.random.nextInt(size), this.random.nextInt(size));
		}
		this.topCardIndex = 0;
	}

	private void changeCards(int indexA, int indexB) {
		final Card tmpCard = this.cards[indexA];
		this.cards[indexA] = this.cards[indexB];
		this.cards[indexB] = tmpCard;
	}

	@Override
	public String toString() {
		final StringBuilder content = new StringBuilder(500);
		content.append("---[ Deck ]---\n");
		for (int i = 0; i < this.cards.length; i++) {
			content.append("[").append(String.format("%1$2s", i + 1)).append("] ").append(this.cards[i]);
			if (i == this.topCardIndex) {
				content.append("  <-- top card");
			}
			content.append("\n");
		}
		return content.toString();
	}

}
