package com.ericsson.sf.thread;

import java.util.Random;

import org.apache.log4j.Logger;

import com.ericsson.sf.engine.Project;

public class Developer extends Thread {

	private static final Logger LOGGER = Logger.getLogger(Developer.class);

	private static final int PAUSE = 500;

	private final Random random;
	private final Project project;
	private final String userName;
	private final int workloadCoefficient;
	private final int impactFactor;

	public Developer(Random random, Project project, String userName, int workloadCoefficient, int impactFactor) {
		this.random = random;
		this.project = project;
		this.userName = userName;
		this.workloadCoefficient = workloadCoefficient;
		this.impactFactor = impactFactor;
	}

	public int getImpactFactor() {
		return this.impactFactor;
	}

	public String getAbbrevation() {
		return this.userName.substring(0, 1).toUpperCase();
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(this.workloadCoefficient + this.random.nextInt(PAUSE));
				this.project.doSomethingParticularlyUsefulThing(this);
				this.waitingForUseMe();
			}
		} catch (final InterruptedException e) {
			LOGGER.error(e, e);
		}
	}

	public synchronized void waitingForUseMe() throws InterruptedException {

	}

	public synchronized void readyToGetANewJob() throws InterruptedException {

	}

	public String getUserName() {
		return this.userName;
	}

	@Override
	public String toString() {
		return this.userName;
	}

}
