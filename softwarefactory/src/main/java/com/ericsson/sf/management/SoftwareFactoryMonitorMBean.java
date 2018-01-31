package com.ericsson.sf.management;

import com.ericsson.sf.management.util.Description;
import com.ericsson.sf.management.util.PName;

@Description("SoftwareFactory Monitor")
public interface SoftwareFactoryMonitorMBean {

	public static final String JMX_NAME = "SoftwareFactoryMonitor";

	@Description("Get number of stories")
	long getNumberOfStories();

	@Description("Get number of developers")
	long getNumberOfDevelopers();

	@Description("Get number of active stories")
	long getNumberOfActiveStories();

	@Description("Get the developer names")
	String[] getDeveloperNames();

	@Description("Get the story identifiers")
	String[] getStoryIdentifiers();

	@Description("Get the story identifiers")
	String getStoryInfo(@PName("identifier") String identifier);

}
