package com.ericsson.huncard;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml")) {
			Game game = context.getBean("game", Game.class);

			game.addPlayer("Julcsi", "Karcsi", "Darth Vader");
			System.out.println(game.play());
			System.out.println(game);
		}
	}

}
