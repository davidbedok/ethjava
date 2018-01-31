package com.ericsson.sf.main;

import java.util.Random;

import com.ericsson.sf.management.JmxAgent;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		final Random random = new Random();
		new JmxAgent("SoftwareFactory");
		new Simulation(random, 2500, 2, 4).start();
	}

}
