package com.ericsson.huncard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ericsson.huncard.factory.DeckFactory;

public class Game {

	private final int numberOfPlayerCards;
	private final Deck deck;
	private final List<Player> players;

	public Game(DeckFactory deckFactory, int numberOfPlayerCards) {
		this.numberOfPlayerCards = numberOfPlayerCards;
		this.deck = deckFactory.getDeck();
		this.players = new ArrayList<>();
	}

	public void addPlayer(String... names) {
		for (final String name : names) {
			this.addPlayer(new Player(name));
		}
	}

	protected void addPlayer(Player player) {
		this.players.add(player);
	}

	public Player play() {
		this.deck.shuffle();
		this.divideCards();
		return this.getWinner();
	}

	private void divideCards() {
		for (int k = 0; k < this.numberOfPlayerCards; k++) {
			for (final Player player : this.players) {
				player.addCard(this.deck.getTopCard());
			}
		}
	}

	private Player getWinner() {
		Player result = null;
		if (this.players.size() > 0) {
			result = this.players.get(0);
			int maximum = result.getScore();
			for (int i = 1; i < this.players.size(); i++) {
				final Player player = this.players.get(i);
				final int score = player.getScore();
				if (maximum < score) {
					result = player;
					maximum = score;
				}
			}
		}
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder content = new StringBuilder(500);
		content.append("---[ Game ]---\n");
		for (final Player player : this.players) {
			content.append(player).append("\n");
		}
		content.append(this.deck);
		return content.toString();
	}

}
