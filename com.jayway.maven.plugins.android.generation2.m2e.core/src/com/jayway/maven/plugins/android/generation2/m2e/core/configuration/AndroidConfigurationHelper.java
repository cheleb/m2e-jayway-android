package com.jayway.maven.plugins.android.generation2.m2e.core.configuration;

import org.apache.maven.model.Plugin;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AndroidConfigurationHelper {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AndroidConfigurationHelper.class);


	public static AndroidConfiguration extractConfiguration(Plugin eclipsePlugin) {

		Xpp3Dom configurationXpp3Dom = (Xpp3Dom) eclipsePlugin
				.getConfiguration();

		if (configurationXpp3Dom == null) {
			LOGGER.warn("No configuration provided.");
			return null;
		}
        AndroidConfiguration conf = new AndroidConfiguration();
		return conf;
	}


}
