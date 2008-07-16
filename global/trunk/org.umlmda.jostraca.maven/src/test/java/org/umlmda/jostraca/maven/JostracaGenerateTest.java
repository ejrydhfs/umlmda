package org.umlmda.jostraca.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.maven.plugin.MojoExecutionException;

import junit.framework.TestCase;

public class JostracaGenerateTest extends TestCase {

	JostracaGenerate generate;
	private File generatedBaseFolder;
	
	public JostracaGenerateTest() {
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		generate = new JostracaGenerate();
		generate.setLog(new Log4JLog(Logger.getLogger(JostracaGenerateTest.class)));

		generatedBaseFolder = new File("generated");
		
		if ( generatedBaseFolder.exists() ) {
			generatedBaseFolder.delete();
		}
	}
	
	public void testExecute() throws Exception {
		List<String> templateFolders = new ArrayList<String>();
		generate.setTemplateBaseFolder(new File("test/templates"));
		generate.setOutputBaseFolder(generatedBaseFolder);
		templateFolders.add("java");
		templateFolders.add("j2ee");
		
		generate.setTemplatePaths(templateFolders);
		generate.setConfigFolder(new File("etc/jostraca"));
		
		try {
			generate.execute();
		} catch (MojoExecutionException e) {
			fail("Unexpected excetion");
			throw e;
		}
	}

}
