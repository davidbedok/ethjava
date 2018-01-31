package com.ericsson.sf.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.ericsson.sf.thread.Developer;
import com.ericsson.sf.thread.Story;

public class ProjectInfo implements Cloneable {

	private static ProjectInfo instance;

	private final AtomicLong numberOfFinishedStories;

	private final List<Developer> developers;
	private final List<Story> stories;

	private ProjectInfo() {
		this.numberOfFinishedStories = new AtomicLong();
		this.developers = new ArrayList<>();
		this.stories = new ArrayList<>();
	}

	public void storyStarted(Story story) {
		this.stories.add(story);
	}

	public long getNumberOfStories() {
		return this.stories.size();
	}

	public void developerJoined(Developer developer) {
		this.developers.add(developer);
	}

	public long getNumberOfDevelopers() {
		return this.developers.size();
	}

	public void storyFinished() {
		this.numberOfFinishedStories.getAndIncrement();
	}

	public long getNumberOfActiveStories() {
		return this.getNumberOfStories() - this.numberOfFinishedStories.get();
	}

	public void addStory(Story story) {
		this.stories.add(story);
	}

	public String[] getDeveloperNames() {
		return null;
	}

	public String[] getStoryIdentifiers() {
		return null;
	}

	public String getStoryInfo(String identifier) {
		final Story story = this.stories.stream().filter(s -> s.getIdentifier().equals(identifier)).findFirst().orElse(null);
		return Optional.ofNullable(story).map(Story::toString).orElse("");
	}

	@Override
	public String toString() {
		final StringBuilder content = new StringBuilder();
		content.append("\n");
		for (final Story story : this.stories) {
			content.append(story).append("\n");
		}
		return content.toString();
	}

	public static ProjectInfo getInstance() {
		if (instance == null) {
			synchronized (ProjectInfo.class) {
				if (instance == null) {
					instance = new ProjectInfo();
				}
			}
		}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
