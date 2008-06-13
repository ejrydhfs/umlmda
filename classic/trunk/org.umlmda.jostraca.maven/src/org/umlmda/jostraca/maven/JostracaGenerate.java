package org.umlmda.jostraca.maven;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.jostraca.Jostraca;
import org.jostraca.JostracaException;
import org.jostraca.Service;
import org.jostraca.util.PropertySet;
import org.jostraca.util.Standard;

/**
 * Goal which touches a timestamp file.
 * 
 * @goal generate
 * @phase generate-sources
 */
public class JostracaGenerate extends AbstractMojo {

	/**
	 * Directories containing templates relatively to templateBaseFolder
	 * 
	 * @parameter
	 * @required
	 */
	@SuppressWarnings("unchecked")
	private List<String> templatePaths;

	/**
	 * Output directory
	 * 
	 * @parameter
	 * @required
	 */
	private File outputBaseFolder;

	/**
	 * Basefolder for the templates
	 * 
	 * @parameter
	 * @required
	 */
	private File templateBaseFolder;

	/**
	 * Jostraca configuration path
	 * 
	 * @parameter
	 * @required
	 */
	private File configFolder;

	public List<String> getTemplatePaths() {
		return templatePaths;
	}

	public void setTemplatePaths(List<String> templatePaths) {
		this.templatePaths = templatePaths;
	}

	public File getConfigFolder() {
		return configFolder;
	}

	public void setConfigFolder(File configFolder) {
		this.configFolder = configFolder;
	}

	public File getOutputBaseFolder() {
		return outputBaseFolder;
	}

	public void setOutputBaseFolder(File outputBaseFolder) {
		this.outputBaseFolder = outputBaseFolder;
	}

	public File getTemplateBaseFolder() {
		return templateBaseFolder;
	}

	public void setTemplateBaseFolder(File templateBaseFolder) {
		this.templateBaseFolder = templateBaseFolder;
	}

	@SuppressWarnings("unchecked")
	public void execute() throws MojoExecutionException {
		getLog().info(
				"Using jostraca configuration in "
						+ configFolder.getAbsolutePath());

		List<String> stdArgs = new ArrayList<String>();

		// Set standard options
		stdArgs.add(Standard.MINUS + Jostraca.ARG_NO_BACKUP);
		stdArgs.add(Standard.MINUS + Jostraca.ARG_NO_COMPILE);
		stdArgs.add(Standard.MINUS + Jostraca.ARG_NO_GENERATE);
		if (configFolder != null) {
			stdArgs.add(Standard.MINUS + Jostraca.ARG_CONFIG);
			stdArgs.add((new File(configFolder, Jostraca.DEFAULT_ConfigPath))
					.toString());
		}

		try {
			for (Iterator<String> ip = templatePaths.iterator(); ip.hasNext();) {
				String entry = ip.next();
				File templatePath = new File(templateBaseFolder, entry);

				if (templatePath.isDirectory()) {
					File[] files = templatePath.listFiles(new FilenameFilter() {

						public boolean accept(File dir, String name) {
							return name.endsWith(".jtm");
						}
					});

					for (int i = 0; i < files.length; i++) {
						File file = files[i];

						compileTemplate(stdArgs, file);
					}
				}

				else if (templatePath.isFile()) {
					compileTemplate(stdArgs, templatePath);
				}

				else {
					getLog().warn("Invalid entry templatePath entry " + entry);
				}
			}
		} catch (JostracaException e) {
			getLog().error(e);
			throw new MojoExecutionException("Error while generating", e);
		} catch (Exception e) {
			getLog().error(e);
			throw new MojoExecutionException("Error while generating", e);
		}
	}

	private void compileTemplate(List<String> stdArgs, File templateFile) {
		List<String> args = new ArrayList<String>(stdArgs);

		String relTemplateFolder = templateFile.getParentFile()
				.getAbsolutePath().substring(
						templateBaseFolder.getAbsolutePath().length());
		File outFolder = new File(outputBaseFolder, relTemplateFolder);

		if (outFolder.exists() == false) {
			outFolder.mkdirs();
		}
		args.add(Standard.MINUS + Jostraca.ARG_OUTPUT_FOLDER);
		args.add(outFolder.getAbsolutePath());
		args.add(templateFile.getAbsolutePath());

		Jostraca.main(args.toArray(new String[args.size()]));
	}

	private PropertySet getCmdLinePropertySet() {
		PropertySet propertySet = new PropertySet();
		// TODO Auto-generated method stub
		return propertySet;
	}

	private PropertySet getConfigPropertySet() {
		PropertySet propertySet = new PropertySet();

		propertySet.set("jostraca.dir", configFolder);
		propertySet.set("jostraca.version", "0.3.3");
		// TODO Auto-generated method stub
		return propertySet;
	}
}
