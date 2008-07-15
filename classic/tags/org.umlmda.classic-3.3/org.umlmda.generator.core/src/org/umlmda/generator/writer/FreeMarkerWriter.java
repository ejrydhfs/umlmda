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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.generator.model.util.Feedback;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.URLTemplateLoader;
import freemarker.ext.beans.BeanModel;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.SimpleHash;
import freemarker.template.Template;


/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FreeMarkerWriter extends AbstractTemplateWriter {
   private Template template = null;
   private final String templateName;
   
   /**
    * @param templateName
    */
   public FreeMarkerWriter(Feedback feedback, final String templateName, List templatePaths) {
      super(feedback, templateName, templatePaths);
      this.templateName = templateName;
      
      // Load the template
      Configuration configuration = new Configuration();
      
      for (Iterator ip = templatePaths.iterator(); template == null && ip.hasNext();) {
         Object pathEntry = ip.next();
         
         if ( pathEntry instanceof String ) {
            pathEntry = new File((String)pathEntry);
         }
         
         if ( pathEntry instanceof File ) {
            File path = (File) pathEntry;

            if (path.exists() && path.isDirectory()) {
               File templateFile = new File(path, templateName);

               if (templateFile.exists()) {
                  try {
                     FileTemplateLoader loader = new FileTemplateLoader(path);

                     configuration.setTemplateLoader(loader);
                     template = configuration.getTemplate(templateName);
                     if (template != null) {
                        feedback.message(Feedback.INFO, "Loaded freemarker template from "
                              + templateFile.getAbsolutePath());
                     }
                  } catch (FileNotFoundException e) {
                     // Ingore
                  } catch (IOException e) {
                     throw new RuntimeException("Error loading " + templateFile.getAbsolutePath(), e);
                  } finally {
                  }
               }
            }
         }
         else if ( pathEntry instanceof URL ) {
            try {
               final URL urlEntry = (URL)pathEntry;
               configuration.setTemplateLoader(new URLTemplateLoader() {

                  protected URL getURL(String name) {
                     try {
                        return new URL(urlEntry.toExternalForm() + "/" + name);
                     } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                     }
                  }
                  });
               template = configuration.getTemplate(templateName);
               if (template != null) {
                  feedback.message(Feedback.INFO, "Loaded freemarker template from "
                        + ((URL)pathEntry).toExternalForm());
               }
            } catch (IOException e) {
               throw new RuntimeException(e);
            } finally {
            }
            
         }
      } // for
      
      if ( template == null ) {
         throw new RuntimeException("template "+templateName+" not found in "+templatePaths);
      }
   }

   public String toString() {
      return getClass().getName()+" using template "+templateName;
   }
  
   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractWriter#writer__initialize()
    */
   protected void writer__initialize() {
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractWriter#writer__write()
    */
   protected void writer__write() throws Exception {
      
      // Prepare the model
      SimpleHash model = new SimpleHash();
      if ( getModelElement() instanceof GeneratorClass ) {
         GeneratorClass genClass = (GeneratorClass) getModelElement();
         
         model.put("genClass", new BeanModel(genClass, new DefaultObjectWrapper()));
         model.put("genPackage", new BeanModel(genClass.getGeneratorPackage(), new DefaultObjectWrapper()));
         model.put("genModel", new BeanModel(genClass.getGeneratorModel(), new DefaultObjectWrapper()));
      }
      else if ( getModelElement() instanceof GeneratorPackage ) {
         GeneratorPackage genPackage = (GeneratorPackage) getModelElement();
         
         model.put("genPackage", genPackage);
         model.put("genModel", genPackage.getGeneratorModel());
      }
            
      // Run the template
      StringBuffer buffer = new StringBuffer();
      
      buffer.append(getOutputFolder().getAbsolutePath());
      buffer.append(File.separator);
      buffer.append(getFilenameRoot());
      buffer.append("");
      buffer.append(getFileExt());

      FileWriter out = new FileWriter(buffer.toString());

      getFeedback().message(Feedback.INFO, "Write template "+templateName+" to "+buffer.toString());
      template.process(model, out);
      out.close();
   }


   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractParentWriter#_getOutputBuffer()
    */
   protected StringBuffer _getOutputBuffer() {
      return null;
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractParentWriter#_setOutputFolder(java.lang.String)
    */
   protected void _setOutputFolder(String outputFolder) {
   }
}
