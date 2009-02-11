/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/DefaultModelVisitor.java,v 1.3.2.1 2008/03/11 15:47:36 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/DefaultModelVisitor.java,v $
 * $Revision: 1.3.2.1 $
 *     $Name:  $
 *     $Date: 2008/03/11 15:47:36 $
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
 * Created by Dieter Moroff (13.04.2006)
 */
package org.umlmda.model.uml;

import org.apache.log4j.Logger;


/**
 * Default implementation of a model visitor, does nothing.
 * @author Dieter Moroff (13.04.2006), last change $Date: 2008/03/11 15:47:36 $ $Name:  $
 * @version $Revision: 1.3.2.1 $
 */
public class DefaultModelVisitor implements ModelVisitor {
   protected Logger logger = Logger.getLogger(getClass().getName());
   
   /**
    * 
    */
   public DefaultModelVisitor(Logger logger) {
      super();
      this.logger = logger;
   }

   /**
    * 
    */
   public DefaultModelVisitor() {
      super();
      logger = Logger.getLogger(getClass().getName());
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.Model)
    */
   public boolean visit(Model model) {
      if ( logger.isDebugEnabled()) {
         logger.debug("visiting model "+model.getQualifiedName());
      }
      return true;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelPackage)
    */
   public boolean visit(ModelPackage modelPackage) {
      if ( logger.isDebugEnabled()) {
         logger.debug("visiting modelPackage "+modelPackage.getQualifiedName());
      }
      return true;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelClass)
    */
   public boolean visit(ModelClass modelClass) {
      if ( logger.isDebugEnabled()) {
         logger.debug("visiting modelClass "+modelClass.getQualifiedName());
      }
      return true;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelAttribute)
    */
   public boolean visit(ModelAttribute attribute) {
      if ( logger.isDebugEnabled()) {
         logger.debug("visiting attribute "+attribute.getQualifiedName());
      }
      return true;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelAssociation)
    */
   public boolean visit(ModelAssociation association) {
      if ( logger.isDebugEnabled()) {
         logger.debug("visiting association "+association.getQualifiedName());
      }
      return true;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelMethod)
    */
   public boolean visit(ModelMethod method) {
      if ( logger.isDebugEnabled()) {
         logger.debug("visiting method "+method.getQualifiedName());
      }
      return true;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelParameter)
    */
   public boolean visit(ModelParameter parameter) {
      if ( logger.isDebugEnabled()) {
         logger.debug("visiting parameter "+parameter.getQualifiedName());
      }
      return true;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelDataType)
    */
   public boolean visit(ModelDataType dataType) {
      if ( logger.isDebugEnabled()) {
         logger.debug("visiting dataType "+dataType.getQualifiedName());
      }
      return true;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelDependency)
    */
   public boolean visit(ModelDependency dependency) {
      if ( logger.isDebugEnabled()) {
         logger.debug("visiting dependency "+dependency.getStereotypes());
      }
      return true;
   }

}
