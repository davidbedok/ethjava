package com.ericsson.huncard;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CardTest {

	private static final int BELL10_VALUE = 20;

	@Test
	public void createCardAndGetItsValue() {
		Card card = new Card(CardSuit.Bells, CardRank.r10);
		Assert.assertEquals(card.getValue(), BELL10_VALUE);
	}

}
