// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractParentWriter.java,v 1.8.2.2 2008/01/21 14:57:27 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractParentWriter.java,v $
// $Revision: 1.8.2.2 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/01/21 14:57:27 $
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
// Created on:      23.07.2003
package org.umlmda.generator;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.generator.model.util.Feedback;
import org.umlmda.generator.model.util.GeneratorRuntime;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.profile.WriterType;
import org.umlmda.generator.writer.FreeMarkerWriter;
import org.umlmda.generator.writer.oaw.XpandWriter;
import org.umlmda.model.uml.ModelElement;



/**
 * Abstrakte Basisklasse für alle Teil-Generatoren, über das hier definierte Interface kann der
 * Generator die Teilgeneratoren aufrufen.
 * @see de.corag.mvcparts.gp.Generator 
 * @author MOROFF
 */
public abstract class AbstractParentWriter extends AbstractWriter {

   private ChildMappings mappings = null;
   private String generatedSource;
   private File outputFolder;
   private Logger logger = Logger.getLogger(getClass());

   /**
    * @return
    */
   abstract protected StringBuffer _getOutputBuffer();

   /**
    * Starts the generation, ensure that the required information is set before calling this method
    */
   public void run() {
      writer__initialize();
      _setOutputFolder(getOutputFolder().getAbsolutePath());
      _setFileNameRoot(getFilenameRoot());
      _setFileNameSuffix(getFileExt());

      // Speichern des Names der generierten Source, nach dem Lauf
      // lässt sich der Name mit _getFileNameRoot() nicht mehr ermitteln
      generatedSource = getOutputFolder().getAbsolutePath() + File.separator + _getFileNameRoot() + _getFileNameSuffix();

      // Writer laufen lassen
      try {
         writer__write();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   /**
    * Method returns the name of the generated source file 
    * @return basename with file extension
    */
   public String getGeneratedSource() {
      return generatedSource;
   }

   /**
    * Method can be overwritten to return the file extension of the generated file
    * otherwise it's used from the current artefact.
    * @return String file extension
    */
   public String getFileExt() {
      if ( getModelElement() instanceof GeneratorModelElement ) {
         GeneratorModelElement genElement = (GeneratorModelElement) getModelElement();
         GeneratorModel genModel = genElement.getGeneratorModel();
         Artefact artefact = genModel.getArtefact();
         
         if ( StringUtils.isNotEmpty(artefact.getFileExtension())) {
            return "." + artefact.getFileExtension();
         }
         else {
            return StringUtils.EMPTY;
         }
      }
      else {
         return StringUtils.EMPTY;
      }
   }

   protected String getFilenameRoot() {
      if ( getModelElement() instanceof GeneratorModelElement ) {
         GeneratorModelElement genElement = (GeneratorModelElement) getModelElement();
         GeneratorModel genModel = genElement.getGeneratorModel();
         Artefact artefact = genModel.getArtefact();
         String filename = artefact.getFilename();
         
         if ( StringUtils.isNotEmpty(filename)) {
            if ( filename.indexOf("/") >= 0 ) {
               String filebaseRoot = filename.substring(filename.lastIndexOf("/"));
               return filebaseRoot;
            }
            else
               return filename;
         }
         else {
            return getBaseName();
         }
      }
      else {
         return getBaseName();
      }
   }
   
   /**
    * Method must be overwritten to return the basename without extension of the generated file. Usually
    * the name is derived from the model associated with the writer. 
    * @return String file base name
    */
   abstract public String getBaseName();

   /**
    * Method returns the current output folder
    * @return output folder
    */
   public File getOutputFolder() {
      return outputFolder;
   }

   /**
    * Method sets the output folder
    */
   public void setOutputFolder(File outputFolder) {
      this.outputFolder = outputFolder;
   }

   /**
    * Method is generated by Jostraca and called in the run method, it shouldn't be called from
    * anywhere else.
    */
   protected abstract void _setFileNameRoot(String fileNameRoot);

   /**
    * Method is generated by Jostraca and called in the run method, it shouldn't be called from
    * anywhere else.
    */
   protected abstract String _getFileNameRoot();

   /**
    * Method is generated by Jostraca and called in the run method, it shouldn't be called from
    * anywhere else.
    */
   protected abstract String _getFileNameSuffix();

   /**
    * Method is generated by Jostraca and called in the run method, it shouldn't be called from
    * anywhere else.
    */
   protected abstract void _setFileNameSuffix(String fileNameSuffix);

   /**
    * Method is generated by Jostraca and called in the run method, it shouldn't be called from
    * anywhere else.
    */
   protected abstract void _setOutputFolder(String outputFolder);


   final protected void runWriter(GeneratorModelElement modelElement)
   {
      String writerName = getWriterName(modelElement);
      
      if ( writerName != null ) {
         Artefact artefact = modelElement.getGeneratorModel().getArtefact(writerName, modelElement);
         
         if ( artefact != null ) {
            AbstractWriter childWriter = null;
            
            if ( artefact.getType() == WriterType.FREE_MARKER_LITERAL ) {
               childWriter = new FreeMarkerWriter(getFeedback(), artefact.getWriter(), getGenerator().getTemplatePaths());
            }
            else if ( artefact.getType() == WriterType.EXPAND_LITERAL ) {
                childWriter = new XpandWriter(GeneratorRuntime.getInstance(), artefact.getWriter(), getGenerator().getTemplatePaths());
            }
            else {
               childWriter = getGenerator().createWriter(getFeedback(), artefact.getWriter());
            }
            if (childWriter instanceof AbstractEmbeddedWriter) {
               AbstractEmbeddedWriter embeddedWriter = (AbstractEmbeddedWriter) childWriter;
            
               logger.debug("Starting "+embeddedWriter.getClass()+" for "+modelElement);
               
               embeddedWriter.setModelElement(modelElement);
               embeddedWriter.setParentWriter(this);
               embeddedWriter._setOutputBuffer(_getOutputBuffer());
               embeddedWriter.run();
            }
            else {
               getFeedback().message(Feedback.WARNING, "writer "+childWriter+getClass()+" must be derived from "+AbstractEmbeddedWriter.class);
            }
         }
         else {
            getFeedback().message(Feedback.WARNING, "No artefact "+writerName+" found");
         }
      }
   }

   protected String getWriterName(Object modelObject) {
      if ( modelObject instanceof ModelElement ) {
         ModelElement modelElement = (ModelElement) modelObject;
         String writerName = mappings.getMapping(modelElement.getStereotype());
         return writerName;
      }
      else
         return null;
   }

   /**
    * @return
    */
   public ChildMappings getMappings() {
      return mappings;
   }

   /**
    * @param mappings
    */
   public void setMappings(ChildMappings mappings) {
      this.mappings = mappings;
   }


}
