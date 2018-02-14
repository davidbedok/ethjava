package com.ericsson.huncard;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Program {

	public static void main(String[] args) {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(HunCardConfiguration.class)) {

			Game game = context.getBean(Game.class);

			game.addPlayer("Julcsi", "Karcsi", "Darth Vader");
			System.out.println(game.play());
			System.out.println(game);
		}
	}

}
