/*
 * Created on 12.12.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.generator.writer;

import java.io.File;
import java.util.List;

import org.umlmda.generator.AbstractModelElementWriter;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.generator.model.util.DefaultClassHelper;
import org.umlmda.generator.model.util.DefaultMethodHelper;
import org.umlmda.generator.model.util.Feedback;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class AbstractTemplateWriter extends AbstractModelElementWriter {
   private GeneratorModelElement genElement;
   protected GeneratorModel genModel;
   protected final String templateName;
   protected final Feedback feedback;
   private String fileNameRoot = null;
   private String fileNameSuffix = null;

   /**
    * @param classHelper
    * @param methodHelper
    */
   public AbstractTemplateWriter(Feedback feedback, String templateName, List templatePaths) {
      super(new DefaultClassHelper(), new DefaultMethodHelper());
      this.templateName = templateName;
      this.feedback = feedback;
   }

   public String getBaseName() {
      return ((GeneratorModelElement)getModelElement()).getGeneratedName();
   }

   public GeneratorPackage getGenPackage() {
      if (getModelElement() instanceof GeneratorClass) {
         GeneratorClass genClass = (GeneratorClass) getModelElement();
         
         return genClass.getGeneratorPackage();
      }
      else if (getModelElement() instanceof GeneratorPackage) {
         GeneratorPackage genPackage = (GeneratorPackage) getModelElement();
         
         return genPackage;
      }
      else {
         throw new RuntimeException("Type "+getModelElement().getClass()+" not supported");
      }
   }

   public void setModelElement(Object element) {
      super.setModelElement(element);
      if (element instanceof GeneratorModelElement) {
         this.genElement = (GeneratorModelElement) element;
         this.genModel = genElement.getGeneratorModel();
      }
   }

   protected void _setFileNameRoot(String fileNameRoot) {
      this.fileNameRoot = fileNameRoot ; 
   }

   protected String _getFileNameRoot() {
      return fileNameRoot;
   }

   protected String _getFileNameSuffix() {
      return fileNameSuffix;
   }

   protected void _setFileNameSuffix(String fileNameSuffix) {
      this.fileNameSuffix = fileNameSuffix;
   }

   protected String getOutputName() {
      StringBuffer buffer = new StringBuffer();
      
      buffer.append(getOutputFolder().getAbsolutePath());
      buffer.append(File.separator);
      buffer.append(getFilenameRoot());
      buffer.append("");
      buffer.append(getFileExt());
   
      String outFileName = buffer.toString();
      return outFileName;
   }


}
