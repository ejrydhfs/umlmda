/*
 * Created on 05.12.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.generator.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.generator.model.util.Feedback;
import org.umlmda.generator.model.util.GeneratorRuntime;



/**
 * Writer to use with velocity templates.
 * @author Dieter Moroff 
 * @since 2.7.0
 */
public class VelocityWriter extends AbstractTemplateWriter {
   private Template template = null;
   
   /**
    * @param templateName
    */
   public VelocityWriter(GeneratorRuntime runtime, String templateName, List templatePaths) {
      super(runtime.getFeedback(), templateName, templatePaths);

      // Load the template
      for (Iterator ip = templatePaths.iterator(); template == null && ip.hasNext();) {
         Object pathEntry = ip.next();
         File path;
         
         if ( pathEntry instanceof File ) {
            path = (File) pathEntry;
         }
         else {
            path = new File((String)pathEntry);
         }
         
         if ( path.exists() && path.isDirectory() ) {
            File templateFile = new File(path, templateName);
            
            if ( templateFile.exists() ) {
               try {
                  VelocityEngine engine = runtime.createVelocityEngine();

                  engine.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, templateFile.getParentFile().getAbsolutePath());
                  engine.init();
                  template = engine.getTemplate(templateFile.getName());
                  if ( template != null ) {
                     feedback.message(Feedback.INFO, "Loaded velocity template from "+templateFile.getAbsolutePath());
                  }
               } catch (FileNotFoundException e) {
                  // Ingore
               } catch (IOException e) {
                  throw new RuntimeException("Error loading "+templateFile.getAbsolutePath(), e);
               } catch (ResourceNotFoundException e) {
                  throw new RuntimeException("Error loading "+templateFile.getAbsolutePath(), e);
               } catch (ParseErrorException e) {
                  throw new RuntimeException("Error parsing "+templateFile.getAbsolutePath(), e);
               } catch (Exception e) {
                  throw new RuntimeException("Error in "+templateFile.getAbsolutePath(), e);
               } finally {
               }
            }
         }
      } // for
      
      if ( template == null ) {
         throw new RuntimeException("template "+templateName+" not found in "+templatePaths);
      }
   }


   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractWriter#writer__initialize()
    */
   protected void writer__initialize() {
      // TODO Auto-generated method stub
      
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractWriter#writer__write()
    */
   protected void writer__write() throws Exception {
      
      // Prepare the model 
      Context model = new VelocityContext();
      if ( getModelElement() instanceof GeneratorClass ) {
         GeneratorClass genClass = (GeneratorClass) getModelElement();
         
         model.put("genClass", genClass);
         model.put("genPackage", genClass.getGeneratorPackage());
         model.put("genModel", genClass.getGeneratorModel());
      }
      else if ( getModelElement() instanceof GeneratorPackage ) {
         GeneratorPackage genPackage = (GeneratorPackage) getModelElement();
         
         model.put("genPackage", genPackage);
         model.put("genModel", genPackage.getGeneratorModel());
      }
            
      // Run the template
      String outputName = getOutputName();
      
      FileWriter out = new FileWriter(outputName);

      getFeedback().message(Feedback.INFO, "Write template "+templateName+" to "+outputName);
      template.merge(model, out);
      out.close();
   }


   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractParentWriter#_getOutputBuffer()
    */
   protected StringBuffer _getOutputBuffer() {
      // TODO Auto-generated method stub
      return null;
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractParentWriter#_setOutputFolder(java.lang.String)
    */
   protected void _setOutputFolder(String outputFolder) {
      // TODO Auto-generated method stub
      
   }
}
