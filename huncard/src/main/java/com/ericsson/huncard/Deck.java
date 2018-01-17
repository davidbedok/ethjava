package com.ericsson.huncard;

import java.util.Random;

public class Deck {

	private static final int SHUFFLE_FACTOR = 100;
	private final Card[] cards;
	private int topCardIndex;
	private final Random random;

	public Deck(Random random) {
		this.random = random;
		CardRank[] ranks = CardRank.values();
		CardSuit[] suits = CardSuit.values();

		this.cards = new Card[suits.length * ranks.length];

		int index = 0;
		for (CardSuit suit : suits) {
			for (CardRank rank : ranks) {
				this.cards[index++] = new Card(suit, rank);
			}
		}
		this.topCardIndex = 0;
	}

	public Card getTopCard() {
		return this.cards[this.topCardIndex++];
	}

	public void shuffle() {
		int size = this.cards.length;
		for (int i = 0; i < SHUFFLE_FACTOR; i++) {
			this.changeCards(this.random.nextInt(size), this.random.nextInt(size));
		}
		this.topCardIndex = 0;
	}

	private void changeCards(int indexA, int indexB) {
		Card tmpCard = this.cards[indexA];
		this.cards[indexA] = this.cards[indexB];
		this.cards[indexB] = tmpCard;
	}

	@Override
	public String toString() {
		StringBuilder content = new StringBuilder(500);
		for (Card card : this.cards) {
			content.append(card).append("\n");
		}
		return content.toString();
	}

}
