package org.umlmda.generator.oaw;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.WorkflowComponentWithModelSlot;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;
import org.umlmda.generator.Generator;
import org.umlmda.generator.anttask.FormatterProvider;
import org.umlmda.generator.set.GenerationSet;
import org.umlmda.model.uml.ModelBase;

/**
 * oAW workflow component to start a classic UMLMDA generate through a workflow.
 * 
 * @author Dieter Moroff
 */
public class ClassicGenerator extends WorkflowComponentWithModelSlot {

   private String generatorProfileSlot;
   private Logger logger = Logger.getLogger(ClassicGenerator.class);
   private List<String> templateFolders = new ArrayList<String>();
   private List<FormatterProvider> formatterProviders = new ArrayList<FormatterProvider>();
   
   public ClassicGenerator() {
   }

   public void addTemplateFolder(String folder) {
      templateFolders.add(folder);
   }
   
   public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
      Object temp;
      GenerationSet generationSet = null;
      Generator generator = new Generator(new OawFeedback(issues, logger));
      
      // Load and check the generator profile
      temp = ctx.get(generatorProfileSlot);
      
      if ( temp instanceof GenerationSet ) {
         generationSet = (GenerationSet) temp;
         
         generator.setGenerationSet(generationSet);
      }
      else {
         issues.addError("GenerationSet not found in slot "+generatorProfileSlot);
      }
      
      // Load the model
      temp = ctx.get(getModelSlot());
      
      if ( temp instanceof ModelBase ) {
         generator.setModel((ModelBase) temp);
      }
      else {
         issues.addError("Model not found in slot "+getModelSlot());
      }

      for (Iterator<FormatterProvider> ifp = formatterProviders.iterator(); ifp.hasNext();) {
         FormatterProvider formatterProvider = ifp.next();
         
         generator.addFormatterProvider(formatterProvider.getFormatterProvider());
      }
      
      // TODO Formatters
      
      // Template paths
      if ( templateFolders.size() > 0 ) {
         List<File> templatePaths = new ArrayList<File>();
         for (Iterator<String> itd = templateFolders.iterator(); itd.hasNext();) {
            String templateFolder = itd.next();
            File folder = new File(templateFolder);
            
            if ( folder.exists() == false ) {
               String msg = "template folder "+folder.getAbsolutePath()+" doesn't exist";
               
               issues.addError(msg);
            }
            
            else if ( folder.isDirectory() == false ) {
               String msg = ""+folder.getAbsolutePath()+" is no directory";
               
               issues.addError(msg);
            }
            
            else {
               logger.info("added template folder "+folder.getAbsolutePath());
            }
            templatePaths.add(folder);
         }
         generator.setTemplatePaths(templatePaths);
      }
      
      if ( generator.run() == 0 ) {
         issues.addError("Nothing generated");
      }

   }

   public String getGeneratorProfile() {
      return generatorProfileSlot;
   }

   public void setGeneratorProfile(String generatorProfile) {
      this.generatorProfileSlot = generatorProfile;
   }

}
