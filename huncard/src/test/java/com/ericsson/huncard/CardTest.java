package com.ericsson.huncard;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CardTest {

	private static final int BELL10_VALUE = 20;

	@Test
	public void createCardAndGetItsValue() {
		Card card = new Card(CardSuit.Bells, CardRank.r10);
		Assert.assertEquals(card.getValue(), BELL10_VALUE);
	}
	
	@Test
	public void getCardValue() {
		final CardRankValuable rank = Mockito.mock(CardRankValuable.class);
		Mockito.when(rank.getValue()).thenReturn(5);
		final CardSuitValuable suit = Mockito.mock(CardSuitValuable.class);
		Mockito.when(suit.getValue()).thenReturn(4);
		
		final Card card = new Card(suit, rank);
		
		Assert.assertEquals(card.getValue(), 20);
	}


}
