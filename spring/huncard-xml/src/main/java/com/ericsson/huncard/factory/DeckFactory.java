package com.ericsson.huncard.factory;

import java.util.Random;

import com.ericsson.huncard.Deck;

public class DeckFactory {

	private final Deck deck;

	public DeckFactory(Random random) {
		this.deck = new Deck(random);
	}

	public Deck getDeck() {
		return this.deck;
	}

}
