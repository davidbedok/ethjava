package com.ericsson.sf.management;

public interface SoftwareFactoryMonitorMBean {

	public static final String JMX_NAME = "SoftwareFactoryMonitor";

	long getNumberOfStories();

	long getNumberOfDevelopers();

	long getNumberOfActiveStories();

	String[] getDeveloperNames();

	String[] getStoryIdentifiers();

	String getStoryInfo(String identifier);

}
