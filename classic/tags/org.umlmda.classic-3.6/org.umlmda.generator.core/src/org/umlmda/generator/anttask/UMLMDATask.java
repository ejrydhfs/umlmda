// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/anttask/UMLMDATask.java,v 1.6.2.1 2008/01/21 14:57:29 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/anttask/UMLMDATask.java,v $
// $Revision: 1.6.2.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/01/21 14:57:29 $
//   $Locker:  $
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public
// License as published by the Free Software Foundation; either
// version 2 of the License, or (at your option) any later version.
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Library General Public License for more details.
//
// You should have received a copy of the GNU Library General Public
// License along with this library; if not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA  02111-1307, USA. The text of license can be also found
// at http://www.gnu.org/copyleft/lgpl.html
// 
// Original author: Dieter Moroff (moroff@users.sourceforge.net)
// Created on:      03.11.2003

package org.umlmda.generator.anttask;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;
import org.umlmda.generator.Generator;
import org.umlmda.generator.model.util.Feedback;

/**
 * Ant task to invoke the UML-Generator
 * @author moroff
 */
public class UMLMDATask extends Task {
   public static class NothingGeneratedException extends BuildException {
      public NothingGeneratedException() {
         super("No files generated exception");
      }
   }
   
   private class AntFeedback implements Feedback {
      public void tellNewStep(String message) {
         log(message);
      }
      public void tellWork(String message) {
         log(message);
      }
      public void message(int severity, String message) {
         if ( severity == DEBUG )
            log(message, Project.MSG_VERBOSE);
         else if ( severity == INFO )
            log(message, Project.MSG_INFO);
         else if ( severity == WARNING )
            log(message, Project.MSG_WARN);
         else   
            log(message, Project.MSG_ERR);
      }
      public void printStackTrace(Throwable throwable) {
         StringWriter writer = new StringWriter(2048);
         
         throwable.printStackTrace(new PrintWriter(writer));
         log(writer.toString(), Project.MSG_ERR);
      }
      
   };
   
   /**
    * Pathname to the model file
    */
   private String modelFile;
   
   /**
    * Pathname to the generation set
    */
   private String generationSet;
   
   /**
    * Pathname to the output folder
    */
   private String outputFolder;
      
   private String modelFactory;
   
   private List pathMapList = new ArrayList();
         
   private List templateDirectoryList = new ArrayList();
   
   /**
    * Stereotype to writer mappings
    */
   private List mappings = new ArrayList();
      
   private List formatterProviders = new ArrayList();
   
   public UMLMDATask() {
      super();
   }

   /* (non-Javadoc)
    * @see org.apache.tools.ant.Task#execute()
    */
   public void execute() throws BuildException {
      Feedback feedback = new AntFeedback();
      Generator generator = new Generator(feedback);
      File baseDir = getProject().getBaseDir();
      
      // configure the generator
      generator.setModelFile(new File(modelFile));
      generator.setGenerationSetName(generationSet);
      generator.setOutputFolder(outputFolder != null ? outputFolder : ".");
      if ( pathMapList.size() > 0 ) {
         Map pathMap = new HashMap();
         for (Iterator iter = pathMapList.iterator(); iter.hasNext();) {
            PathMapEntry entry = (PathMapEntry) iter.next();
            
            pathMap.put(entry.getEntry(), entry.getPath());
         }
         generator.setPathMap(pathMap);
      }
      for (Iterator ifp = formatterProviders.iterator(); ifp.hasNext();) {
         FormatterProvider formatterProvider = (FormatterProvider) ifp.next();
         
         generator.addFormatterProvider(formatterProvider.getFormatterProvider());
      }
      
      List templatePaths = new ArrayList();
      for (Iterator itd = templateDirectoryList.iterator(); itd.hasNext();) {
         TemplateDirectory dirEntry = (TemplateDirectory) itd.next();
         File dir = new File(dirEntry.getDir());
         
         if ( dir.exists() == false ) {
            String msg = "template directory "+dir.getAbsolutePath()+" doesn't exist";
            
            throw new BuildException(msg);
         }
         
         if ( dir.isDirectory() == false ) {
            String msg = ""+dir.getAbsolutePath()+" is no directory";
            
            throw new BuildException(msg);
         }
         
         templatePaths.add(dir);
      }
      generator.setTemplatePaths(templatePaths);
      
      if ( modelFactory != null )
         generator.setModelFactoryName(modelFactory);

      try {
         if ( generator.run() == 0 ) {
            throw new NothingGeneratedException();
         }
      }
      catch (NothingGeneratedException e) {
         throw e;
      }
      catch (Throwable e) {
         feedback.printStackTrace(e);
         throw new BuildException(e.toString(), e);
      }
   }


   /**
    * @return
    */
   public String getModelFile() {
      return modelFile;
   }

   /**
    * @param string
    */
   public void setModelFile(String string) {
      modelFile = string;
   }

   public String getGenerationSet() {
      return generationSet;
   }
   
   public void setGenerationSet(String generationSet) {
      this.generationSet = generationSet;
   }
   
   /**
    * @return
    */
   public String getModelFactory() {
      return modelFactory;
   }

   /**
    * @param string
    */
   public void setModelFactory(String string) {
      modelFactory = string;
   }

	public void addPathMapEntry(PathMapEntry entry) {
      pathMapList.add(entry);
   }
   
   /**
    * Adds the template directory to the task
    * @param templateDirectory
    */
   public void addTemplateDirectory(TemplateDirectory templateDirectory) {
      templateDirectoryList.add(templateDirectory);
   }
   
   /**
    * @return Returns the outputFolder.
    */
   public String getOutputFolder() {
      return outputFolder;
   }
   
   /**
    * @param outputFolder The outputFolder to set.
    */
   public void setOutputFolder(String outputFolder) {
      this.outputFolder = outputFolder;
   }
   /**
    * @param formatterProvider The formatterProvider to set.
    */
   public void addFormatterProvider(FormatterProvider formatterProvider) {
      this.formatterProviders.add(formatterProvider);
   }
}
