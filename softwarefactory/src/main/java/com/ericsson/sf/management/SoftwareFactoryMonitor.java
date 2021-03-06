package com.ericsson.sf.management;

import javax.management.NotCompliantMBeanException;

import com.ericsson.sf.engine.ProjectInfo;
import com.ericsson.sf.management.util.AnnotatedStandardMBean;

public class SoftwareFactoryMonitor extends AnnotatedStandardMBean implements SoftwareFactoryMonitorMBean {

	public SoftwareFactoryMonitor() throws NotCompliantMBeanException {
		this(SoftwareFactoryMonitorMBean.class);
	}

	protected SoftwareFactoryMonitor(Class<SoftwareFactoryMonitorMBean> mbeanClazz) throws NotCompliantMBeanException {
		super(mbeanClazz);
	}

	@Override
	public long getNumberOfStories() {
		return ProjectInfo.getInstance().getNumberOfStories();
	}

	@Override
	public long getNumberOfDevelopers() {
		return ProjectInfo.getInstance().getNumberOfDevelopers();
	}

	@Override
	public long getNumberOfActiveStories() {
		return ProjectInfo.getInstance().getNumberOfActiveStories();
	}

	@Override
	public String[] getDeveloperNames() {
		return ProjectInfo.getInstance().getDeveloperNames();
	}

	@Override
	public String[] getStoryIdentifiers() {
		return ProjectInfo.getInstance().getStoryIdentifiers();
	}

	@Override
	public String getStoryInfo(String identifier) {
		return ProjectInfo.getInstance().getStoryInfo(identifier);
	}

}
