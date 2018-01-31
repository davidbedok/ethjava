package com.ericsson.sf.engine;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import org.apache.log4j.Logger;

import com.ericsson.sf.thread.Developer;
import com.ericsson.sf.thread.Story;

public class Project {

	private static final Logger LOGGER = Logger.getLogger(Story.class);

	private final Random random;
	private final Queue<Developer> usableSlaves;

	public Project(Random random) {
		this.random = random;
		this.usableSlaves = new LinkedList<>();
	}

	public void addDeveloper(String name, int workloadCoefficient, int impactFactor) {
		final Developer developer = new Developer(this.random, this, name, workloadCoefficient, impactFactor);
		LOGGER.info("Add " + developer + " to the project...");
		developer.start();
		ProjectInfo.getInstance().developerJoined(developer);
	}

	public void addStory(String identifier, int amountOfWork) {
		final Story story = new Story(this.random, this, identifier, amountOfWork);
		LOGGER.info("Add " + story + " to the project...");
		story.start();
		ProjectInfo.getInstance().storyStarted(story);
	}

	public synchronized void doSomethingParticularlyUsefulThing(Developer developer) throws InterruptedException {
		LOGGER.info(developer + " is looking for job...");
		this.usableSlaves.add(developer);
		this.notifyAll();
	}

	public synchronized void captureSlaveForDoSomethingTremendouslyUsefulThing(Story story) throws InterruptedException {
		while (this.usableSlaves.isEmpty()) {
			LOGGER.info("Project is waiting for a free developer...");
			this.wait();
		}
		final Developer developer = this.usableSlaves.poll();
		LOGGER.info(developer + " is working on " + story);
		story.increment(developer);
		developer.readyToGetANewJob();
		this.notifyAll();
		LOGGER.info(ProjectInfo.getInstance());
	}

}
