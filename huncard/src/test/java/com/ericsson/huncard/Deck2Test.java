package com.ericsson.huncard;

import java.util.Random;

import org.testng.annotations.Test;

public class Deck2Test {

	private class MockedRandom extends Random {

		private int numberOfCall;

		public MockedRandom() {
			this.numberOfCall = 0;
		}

		@Override
		public int nextInt(int bound) {
			this.numberOfCall++;
			return this.numberOfCall % 2 == 0 ? 3 : 1;
		}
	}

	@Test
	public void properShufferBehavior() {
		Deck deck = new Deck(new MockedRandom());

		System.out.println(deck);

		deck.shuffle();

		System.out.println(deck);

	}

}
