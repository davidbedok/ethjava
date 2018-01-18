package com.ericsson.huncard;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerTest {

	@Test
	public void playerHasntGotAnyCards() {
		Player player = new Player("Lorem");
		Assert.assertEquals(player.getScore(), 0);
		Assert.assertEquals(player.dropCards().length, 0);
	}

	@Test
	public void playerHasGotOneCard() {
		Card card = Mockito.mock(Card.class);
		Mockito.when(card.getValue()).thenReturn(42);

		Player player = new Player("Lorem");
		player.addCard(card);
		Assert.assertEquals(player.getScore(), 42);

		Card[] droppedCards = player.dropCards();

		Assert.assertEquals(droppedCards.length, 1);
		Assert.assertEquals(droppedCards[0], card);
		Assert.assertEquals(player.getScore(), 0);
	}

	@Test
	public void playerHasGotMultipleCards() {
		Card card1 = Mockito.mock(Card.class);
		Mockito.when(card1.getValue()).thenReturn(20);
		Card card2 = Mockito.mock(Card.class);
		Mockito.when(card2.getValue()).thenReturn(22);

		Player player = new Player("Lorem");
		player.addCard(card1);
		player.addCard(card2);
		Assert.assertEquals(player.getScore(), 42);

		Card[] droppedCards = player.dropCards();

		Assert.assertEquals(droppedCards.length, 2);
		Assert.assertEquals(droppedCards[0], card1);
		Assert.assertEquals(droppedCards[1], card2);
		Assert.assertEquals(player.getScore(), 0);
	}

}
