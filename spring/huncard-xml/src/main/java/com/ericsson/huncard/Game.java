package com.ericsson.huncard;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private int numberOfPlayerCards;
	private Deck deck;

	private final List<Player> players;

	public Game() {
		this.players = new ArrayList<>();
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public void setNumberOfPlayerCards(int numberOfPlayerCards) {
		this.numberOfPlayerCards = numberOfPlayerCards;
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
		this.dealCards();
		return this.getWinners();
	}

	private void dealCards() {
		for (int k = 0; k < this.numberOfPlayerCards; k++) {
			for (final Player player : this.players) {
				player.addCard(this.deck.getTopCard());
			}
		}
	}

	private Player getWinners() {
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
