package com.ericsson.huncard;

import java.util.Random;

public class Game {

	private static final int NUMBER_OF_MAX_PLAYERS = 4;
	private final Deck deck;
	private final Player[] players;
	private int playerIndex;

	public Game(Random random) {
		this.deck = new Deck(random);
		this.players = new Player[NUMBER_OF_MAX_PLAYERS];
		this.playerIndex = 0;
	}

	public void addPlayer(String... names) {
		for (final String name : names) {
			this.addPlayer(new Player(name));
		}
	}

	private void addPlayer(Player player) {
		this.players[this.playerIndex++] = player;
	}

	public Player play() {
		this.deck.shuffle();
		this.divideCards();
		return this.getWinners();
	}

	private void divideCards() {
		for (int k = 0; k < Player.NUMBER_OF_PLAYER_CARDS; k++) {
			for (int i = 0; i < this.playerIndex; i++) {
				this.players[i].addCard(this.deck.getTopCard());
			}
		}
	}

	private Player getWinners() {
		Player result = this.players[0];
		int maximum = result.getScore();
		for (int i = 1; i < this.playerIndex; i++) {
			final int currentScore = this.players[i].getScore();
			if (maximum < currentScore) {
				result = this.players[i];
				maximum = currentScore;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder content = new StringBuilder(500);
		content.append("---[ Game ]---\n");
		for (int i = 0; i < this.playerIndex; i++) {
			content.append(this.players[i]).append("\n");
		}
		content.append(this.deck);
		return content.toString();
	}

}
