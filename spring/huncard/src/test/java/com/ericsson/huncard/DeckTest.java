package com.ericsson.huncard;

import java.util.Random;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeckTest {

	private static final int NUMBER_OF_CARDS = 32;

	@InjectMocks
	private Deck deck;

	@Mock
	private Random random;

	@BeforeClass
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(this.deck, "shuffleFactor", 1);
	}

	@Test
	public void getSomeCardsFromTheTop() {
		this.deck.initDeck();
		Assert.assertEquals(this.deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r7));
		Assert.assertEquals(this.deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r8));
	}

	@Test
	public void verifyDeckShuffleInternalBehavior() {
		this.deck.initDeck();
		Mockito.when(this.random.nextInt(NUMBER_OF_CARDS)).thenReturn(1).thenReturn(3);

		Assert.assertEquals(this.deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r7));
		Assert.assertEquals(this.deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r8));
		Assert.assertEquals(this.deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r9));
		Assert.assertEquals(this.deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r10));

		this.deck.shuffle();

		Assert.assertEquals(this.deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r7));
		Assert.assertEquals(this.deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r10));
		Assert.assertEquals(this.deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r9));
		Assert.assertEquals(this.deck.getTopCard(), new Card(CardSuit.Acorns, CardRank.r8));
	}

}
