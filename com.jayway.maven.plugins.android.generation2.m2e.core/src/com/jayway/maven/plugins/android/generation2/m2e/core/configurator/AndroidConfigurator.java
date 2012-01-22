package com.jayway.maven.plugins.android.generation2.m2e.core.configurator;

import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.MojoExecution;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2e.core.lifecyclemapping.model.IPluginExecutionMetadata;
import org.eclipse.m2e.core.project.IMavenProjectFacade;
import org.eclipse.m2e.core.project.configurator.AbstractBuildParticipant;
import org.eclipse.m2e.core.project.configurator.AbstractProjectConfigurator;
import org.eclipse.m2e.core.project.configurator.MojoExecutionBuildParticipant;
import org.eclipse.m2e.core.project.configurator.ProjectConfigurationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jayway.maven.plugins.android.generation2.m2e.core.configuration.AndroidConfiguration;
import com.jayway.maven.plugins.android.generation2.m2e.core.configuration.AndroidConfigurationHelper;


public class AndroidConfigurator extends AbstractProjectConfigurator {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(AndroidConfigurator.class);

	private static final String MOJO_GA = "com.jayway.maven.plugins.android.generation2:android-maven-plugin";

	@Override
	public void configure(
			ProjectConfigurationRequest projectConfigurationRequest,
			IProgressMonitor monitor) throws CoreException {

		IProject project = projectConfigurationRequest.getProject();

		MavenProject mavenProject = projectConfigurationRequest
				.getMavenProject();

		Plugin plugin = mavenProject
				.getPlugin(MOJO_GA);
		if (plugin == null) {
			LOGGER.info("Should not occurs ... but could not set eclipse settings, consider " + MOJO_GA + "!");
		} else {
			LOGGER.info("Using " + MOJO_GA + "  configuration");
			
			AndroidConfiguration conf = AndroidConfigurationHelper.extractConfiguration(plugin);
			
			
		}

	}
	
	
	
	@Override
	public AbstractBuildParticipant getBuildParticipant(
			IMavenProjectFacade projectFacade, MojoExecution execution,
			IPluginExecutionMetadata executionMetadata) {
		return new MojoExecutionBuildParticipant(execution, true);
	}



}
