package com.ericsson.huncard;

import java.util.Random;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeckTest {

	private static final int NUMBER_OF_CARDS = 32;

	@Test
	public void getSomeCardsFromTheTop() {
		Deck deck = new Deck(new Random());

		Assert.assertEquals(deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r7));
		Assert.assertEquals(deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r8));
	}

	@Test
	public void verifyDeckShuffleInternalBehavior() {
		Random random = Mockito.mock(Random.class);

		Mockito.when(random.nextInt(NUMBER_OF_CARDS)).thenReturn(1).thenReturn(3);

		Deck deck = new Deck(random);

		Assert.assertEquals(deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r7));
		Assert.assertEquals(deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r8));
		Assert.assertEquals(deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r9));
		Assert.assertEquals(deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r10));

		deck.shuffle();

		Assert.assertEquals(deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r7));
		Assert.assertEquals(deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r10));
		Assert.assertEquals(deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r9));
		Assert.assertEquals(deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r8));
	}

}
