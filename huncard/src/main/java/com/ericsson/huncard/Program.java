package com.ericsson.huncard;

import java.util.Random;

public class Program {

	public static void main(String[] args) {
		final Game game = new Game(new Random());
		game.addPlayer("Julcsi", "Karcsi", "Darth Vader");
		System.out.println(game.play());
		System.out.println(game);
	}

}
