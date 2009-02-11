/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/pattern/ModelPatternIterator.java,v 1.1 2006/05/04 15:16:30 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/pattern/ModelPatternIterator.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2006/05/04 15:16:30 $
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
package org.umlmda.model.uml.pattern;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDependency;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.ModelVisitor;
import org.umlmda.model.uml.utils.ModelIterator;
import org.umlmda.model.uml.utils.ModelVisitableIterator;

/**
 * Iterates the model and applies all patterns
 * @author Dieter Moroff (28.04.2006), last change $Date: 2006/05/04 15:16:30 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public class ModelPatternIterator {
   private final List patterns;
   private Logger logger = Logger.getLogger(getClass().getName());
   
   /**
    * 
    */
   public ModelPatternIterator(ModelPatternFactory patternFactory) {
      super();
      if ( patternFactory != null ) {
         patterns = patternFactory.createPatterns();
      }
      else {
         patterns = Collections.EMPTY_LIST;
      }
   }

   /**
    * Apply all patterns on the modell
    * @param model
    */
   public void apply(Model model) {
      if ( patterns.size() > 0 ) {
      new ModelIterator(new ModelIterator.Action() {
         public void process(ModelElement modelElement) {
            ModelPatternIterator.this.applyModelElement(modelElement);
         }}).iterate(model);
      }
   }
   
   private void applyModelElement(ModelElement modelElement) {
      for (Iterator ip = patterns.iterator(); ip.hasNext();) {
         ModelPattern pattern = (ModelPattern) ip.next();
         
         if ( pattern.isPatternFor(modelElement.getClass()) 
           && pattern.isPatternFor(modelElement) ) {
            pattern.apply(modelElement);
         }
      }
   }
}
