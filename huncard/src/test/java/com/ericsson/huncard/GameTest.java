package com.ericsson.huncard;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ericsson.huncard.factory.DeckFactory;

public class GameTest {

	private static final int NUMBER_OF_PLAYER_CARDS = 2;

	private Card card1st;
	private Card card2nd;
	private Card card3rd;
	private Card card4th;

	@BeforeClass
	public void setup() {
		this.card1st = Mockito.mock(Card.class);
		this.card2nd = Mockito.mock(Card.class);
		this.card3rd = Mockito.mock(Card.class);
		this.card4th = Mockito.mock(Card.class);
	}

	@Test
	public void normalGameplay() {
		final Deck deck = this.buildDeck();
		final DeckFactory deckFactory = Mockito.mock(DeckFactory.class);
		Mockito.when(deckFactory.getDeck()).thenReturn(deck);

		final Player player1st = Mockito.mock(Player.class);
		final Player player2nd = Mockito.mock(Player.class);

		Mockito.when(player1st.getScore()).thenReturn(100);
		Mockito.when(player2nd.getScore()).thenReturn(99);

		final Game game = new Game(deckFactory, NUMBER_OF_PLAYER_CARDS);
		game.addPlayer(player1st);
		game.addPlayer(player2nd);

		final Player winner = game.play();

		Mockito.verify(deck).shuffle();

		Mockito.verify(player1st).addCard(this.card1st);
		Mockito.verify(player1st).addCard(this.card3rd);
		Mockito.verify(player2nd).addCard(this.card2nd);
		Mockito.verify(player2nd).addCard(this.card4th);

		Assert.assertEquals(winner, player1st);
	}

	private Deck buildDeck() {
		final Deck deck = Mockito.mock(Deck.class);
		Mockito.when(deck.getTopCard()).thenReturn(this.card1st).thenReturn(this.card2nd).thenReturn(this.card3rd).thenReturn(this.card4th);
		return deck;
	}

}
