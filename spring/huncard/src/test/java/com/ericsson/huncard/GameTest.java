package com.ericsson.huncard;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GameTest {

	private static final int NUMBER_OF_PLAYING_CARDS = 2;

	@InjectMocks
	private Game game;

	@Mock
	private Deck deck;

	@Mock
	private Player player1st;
	@Mock
	private Player player2nd;

	@Mock
	private Card card1st;
	@Mock
	private Card card2nd;
	@Mock
	private Card card3rd;
	@Mock
	private Card card4th;

	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(this.game, "numberOfPlayerCards", NUMBER_OF_PLAYING_CARDS);
		Mockito.when(this.deck.getTopCard()).thenReturn(this.card1st).thenReturn(this.card2nd).thenReturn(this.card3rd).thenReturn(this.card4th);
		this.game.addPlayer(this.player1st);
		this.game.addPlayer(this.player2nd);
	}

	@Test
	public void normalGameplay() {
		Mockito.when(this.player1st.getScore()).thenReturn(100);
		Mockito.when(this.player2nd.getScore()).thenReturn(99);

		Player winner = this.game.play();

		Mockito.verify(this.deck).shuffle();

		Mockito.verify(this.player1st).addCard(this.card1st);
		Mockito.verify(this.player1st).addCard(this.card3rd);
		Mockito.verify(this.player2nd).addCard(this.card2nd);
		Mockito.verify(this.player2nd).addCard(this.card4th);

		Assert.assertEquals(winner, this.player1st);
	}

}
