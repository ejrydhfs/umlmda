/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/utils/ModelLoggingVisitor.java,v 1.2 2007/01/03 21:12:44 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/utils/ModelLoggingVisitor.java,v $
 * $Revision: 1.2 $
 *     $Name:  $
 *     $Date: 2007/01/03 21:12:44 $
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created by Dieter Moroff (28.04.2006)
 */
package org.umlmda.model.uml.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDependency;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.ModelVisitor;

/**
 * Implementation of a visitor to log all model elements
 * 
 * @author Dieter Moroff (28.04.2006), last change $Date: 2007/01/03 21:12:44 $ $Name:  $
 * @version $Revision: 1.2 $
 */
public class ModelLoggingVisitor implements ModelVisitor {
   private final Level logLevel;

   private final Logger logger;

   /**
    *  
    */
   public ModelLoggingVisitor(Level logLevel, Logger logger) {
      this.logLevel = logLevel;
      this.logger = logger;
      if ( logger.isLoggable(Level.INFO)) {
         Level level = logger.getLevel();
         logger.log(Level.INFO, "using logger "+logger.getName()+" with level "+level);
      }
   }

   /**
    *  
    */
   public ModelLoggingVisitor(String loggerName) {
      this(Level.INFO, loggerName);
   }

   /**
    *  
    */
   public ModelLoggingVisitor(Level logLevel, String loggerName) {
      this(logLevel, Logger.getLogger(loggerName));
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.Model)
    */
   public boolean visit(Model model) {
      if (logger.isLoggable(logLevel))
         logger.log(logLevel, "Model: " + model + " (" + model.getClass().getName() + ")");
      return true;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelPackage)
    */
   public boolean visit(ModelPackage modelPackage) {
      if (logger.isLoggable(logLevel))
         logger.log(logLevel, "Model-Package: " + modelPackage.toString() + " (" + modelPackage.getClass().getName()
               + ")");
      return true;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelClass)
    */
   public boolean visit(ModelClass modelClass) {
      if (logger.isLoggable(logLevel))
         logger.log(logLevel, "Model-Class: " + modelClass.toString() + " (" + modelClass.getClass().getName() + ")");
      return true;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelAttribute)
    */
   public boolean visit(ModelAttribute attribute) {
      if (logger.isLoggable(logLevel))
         logger.log(logLevel, "Model-Attribute: " + attribute.toString() + " (" + attribute.getClass().getName() + ")");
      return true;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelAssociation)
    */
   public boolean visit(ModelAssociation association) {
      if (logger.isLoggable(logLevel))
         logger.log(logLevel, "Model-Assocations: " + association.toString() + " (" + association.getClass().getName()
               + ")");
      return true;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelMethod)
    */
   public boolean visit(ModelMethod method) {
      if (logger.isLoggable(logLevel))
         logger.log(logLevel, "Model-Method: " + method.toString() + " (" + method.getClass().getName() + ")");
      return true;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelParameter)
    */
   public boolean visit(ModelParameter parameter) {
      if (logger.isLoggable(logLevel))
         logger.log(logLevel, "Model-Parameter: " + parameter.toString() + " (" + parameter.getClass().getName() + ")");
      return true;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelDataType)
    */
   public boolean visit(ModelDataType dataType) {
      if (logger.isLoggable(logLevel))
         logger.log(logLevel, "Model-Datatype: " + dataType.toString() + " (" + dataType.getClass().getName() + ")");
      return true;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelDependency)
    */
   public boolean visit(ModelDependency dependency) {
      if (logger.isLoggable(logLevel))
         logger.log(logLevel, "Model-Dependency: " + dependency.toString() + " (" + dependency.getClass().getName()
               + ")");
      return true;
   }

}
