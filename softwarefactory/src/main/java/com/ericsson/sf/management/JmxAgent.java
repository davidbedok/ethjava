package com.ericsson.sf.management;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.apache.log4j.Logger;

import com.ericsson.sf.management.util.AnnotatedStandardMBean;

public class JmxAgent {

	private static final Logger LOGGER = Logger.getLogger(JmxAgent.class);

	private static final String TYPE_PREFIX = ":type=";

	private final MBeanServer server;

	public JmxAgent(String groupName) {
		this.server = ManagementFactory.getPlatformMBeanServer();
		try {
			this.registerMBean(this.server, new SoftwareFactoryMonitor(), SoftwareFactoryMonitorMBean.class, groupName, SoftwareFactoryMonitorMBean.JMX_NAME);
		} catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | MalformedObjectNameException e) {
			LOGGER.error(e, e);
		}
	}

	private <T> void registerMBean(final MBeanServer server, final T bean, final Class<T> beanInterface, String groupName, final String jmxName)
			throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException {
		final Object annotatedBean = new AnnotatedStandardMBean(bean, beanInterface);
		server.registerMBean(annotatedBean, this.buildObjectName(groupName, jmxName));
	}

	private ObjectName buildObjectName(final String groupName, final String name) throws MalformedObjectNameException {
		return new ObjectName(groupName + TYPE_PREFIX + name);
	}

}
