package com.ericsson.sf.engine;

import java.util.Random;

import org.apache.log4j.Logger;

import com.ericsson.sf.thread.Developer;
import com.ericsson.sf.thread.Story;

public class Project {

	private static final Logger LOGGER = Logger.getLogger(Story.class);

	private final Random random;

	public Project(Random random) {
		this.random = random;
	}

	public void addDeveloper(String name, int workloadCoefficient, int impactFactor) {
		final Developer developer = new Developer(this.random, this, name, workloadCoefficient, impactFactor);
		LOGGER.info("Add " + developer + " to the project...");
		ProjectInfo.getInstance().developerJoined(developer);
	}

	public void addStory(String identifier, int amountOfWork) {
		final Story story = new Story(this.random, this, identifier, amountOfWork);
		LOGGER.info("Add " + story + " to the project...");
		ProjectInfo.getInstance().storyStarted(story);
	}

	public synchronized void doSomethingParticularlyUsefulThing(Developer developer) throws InterruptedException {
		LOGGER.info(developer + " is looking for job...");
	}

	public synchronized void captureSlaveForDoSomethingTremendouslyUsefulThing(Story story) throws InterruptedException {
		LOGGER.info(ProjectInfo.getInstance());
	}

}
