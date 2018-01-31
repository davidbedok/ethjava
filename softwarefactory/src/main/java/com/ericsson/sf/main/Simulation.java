package com.ericsson.sf.main;

import java.util.Random;
import java.util.UUID;

import com.ericsson.sf.engine.Project;

public class Simulation {

	private static final int MAXIMUM_STORY_LENGTH = 30;
	private static final int MINIMUM_STORY_LENGTH = 5;
	private final Random random;
	private final Project project;
	private final int speedCoefficient;
	private final int storyIncomingSpeed;
	private final int developerIncomingSpeed;

	private int storyIndex;
	private int developerIndex;

	public Simulation(Random random, int speedCoefficient, int storyIncomingSpeed, int developerIncomingSpeed) {
		this.random = random;
		this.project = new Project(this.random);
		this.speedCoefficient = speedCoefficient;
		this.storyIncomingSpeed = storyIncomingSpeed;
		this.developerIncomingSpeed = developerIncomingSpeed;
	}

	public void start() throws InterruptedException {
		this.storyIndex = 1;
		this.developerIndex = 1;
		while (true) {
			this.createNewStories();
			Thread.sleep(this.random.nextInt(this.speedCoefficient));
			this.addNewDevelopers();
		}
	}

	private void createNewStories() {
		final int numberOfNewStories = this.randomRange(1, this.storyIncomingSpeed);
		for (int i = 0; i < numberOfNewStories; i++) {
			this.project.addStory(this.getRandomIdentifier("BID", this.storyIndex++), this.getRandomStoryAmountOfWork());
		}
	}

	private String getRandomIdentifier(String prefix, int index) {
		return prefix + "-" + String.format("%04d", index);
	}

	private int getRandomStoryAmountOfWork() {
		return this.randomRange(MINIMUM_STORY_LENGTH, MAXIMUM_STORY_LENGTH);
	}

	private void addNewDevelopers() {
		final int numberOfNewDeveloper = this.randomRange(1, this.developerIncomingSpeed);
		for (int i = 0; i < numberOfNewDeveloper; i++) {
			this.project.addDeveloper(this.getRandomName(this.random, this.developerIndex++), this.getRandomDeveloperWorkload(), this.getRandomImpactFactor());
		}
	}

	private String getRandomName(Random random, int index) {
		return (char) (random.nextInt(26) + 'a') + UUID.randomUUID().toString().substring(0, 6) + "-" + String.format("%04d", index);
	}

	private int getRandomDeveloperWorkload() {
		return this.randomRange(2000, 7000);
	}

	private int getRandomImpactFactor() {
		return this.randomRange(1, 4);
	}

	private int randomRange(int low, int high) {
		return this.random.nextInt(high - low) + low;
	}

}
