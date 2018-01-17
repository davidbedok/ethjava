package com.ericsson.huncard;

import java.util.Random;

public class Program {

	public static void main(String[] args) {

		final Game g = new Game(new Random());

		g.addPlayer("Julcsi", "Karcsi", "Darth Vader");

		System.out.println(g.play());

		System.out.println(g);

	}

}
