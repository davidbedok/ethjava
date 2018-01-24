package com.ericsson.huncard;

import java.util.Random;

import com.ericsson.huncard.factory.DeckFactory;

public class Program {

	public static void main(String[] args) {
		final Game game = new Game(new DeckFactory(new Random()), 5);
		game.addPlayer("Julcsi", "Karcsi", "Darth Vader");
		System.out.println(game.play());
		System.out.println(game);
	}

}
