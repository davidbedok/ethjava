package com.ericsson.huncard;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeckWithFakeRandomTest {

	private class MockedRandom extends Random {

		private static final long serialVersionUID = 1L;

		private int numberOfCall;

		public MockedRandom() {
			this.numberOfCall = 0;
		}

		@Override
		public int nextInt(int bound) {
			return this.numberOfCall++ < 1 ? 1 : 3;
		}
	}

	@Test
	public void verifyDeckShuffleInternalBehavior() {
		Deck deck = new Deck(new MockedRandom());

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
