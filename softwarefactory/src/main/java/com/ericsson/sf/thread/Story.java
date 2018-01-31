package com.ericsson.sf.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.ericsson.sf.domain.HistoryItem;
import com.ericsson.sf.engine.Project;
import com.ericsson.sf.engine.ProjectInfo;

public class Story extends Thread {

	private static final Logger LOGGER = Logger.getLogger(Story.class);

	private static final int INTEGRATION = 3000;

	private final Random random;
	private final Project project;
	private final String identifier;
	private final int amountOfWork;

	private int currentAmountOfWork;

	private final List<HistoryItem> history;

	public Story(Random random, Project project, String identifier, int amountOfWork) {
		this.random = random;
		this.project = project;
		this.identifier = identifier;
		this.amountOfWork = amountOfWork;
		this.currentAmountOfWork = 0;
		this.history = new ArrayList<>();
	}

	public String getIdentifier() {
		return this.identifier;
	}

	@Override
	public void run() {
		try {
			while (this.amountOfWork > this.currentAmountOfWork) {
				Thread.sleep(this.random.nextInt(INTEGRATION));
				this.project.captureSlaveForDoSomethingTremendouslyUsefulThing(this);
			}
			LOGGER.info("DONE! " + this);
			ProjectInfo.getInstance().storyFinished();
		} catch (final InterruptedException e) {
			LOGGER.error(e, e);
		}
	}

	public void increment(Developer developer) {
		final int devAmountOfWork = developer.getImpactFactor();
		final int realWork = (this.currentAmountOfWork + devAmountOfWork) > this.amountOfWork ? this.amountOfWork - this.currentAmountOfWork : devAmountOfWork;
		this.history.add(new HistoryItem(developer, realWork));
		this.currentAmountOfWork += realWork;
	}

	@Override
	public String toString() {
		final double statusPercentage = Double.valueOf(this.currentAmountOfWork) / this.amountOfWork * 100;
		return String.format("%-9s", this.identifier) + this.printHistory() + " " + Math.round(statusPercentage) + "%";
	}

	public String printHistory() {
		final StringBuilder content = new StringBuilder(50);
		content.append("[");
		for (final HistoryItem item : this.history) {
			content.append(item);
		}
		if (this.currentAmountOfWork < this.amountOfWork) {
			content.append(String.format("%-" + (this.amountOfWork - this.currentAmountOfWork) + "s", ""));
		}
		content.append("]");
		return content.toString();
	}

}
