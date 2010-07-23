/*
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
 * Diagnostic utility to get some model statistics.
 * 
 */
public class ModelStatistic
{
   private final Model model;
   private int         packages    = 0;
   private int         classes     = 0;
   private int         methods     = 0;
   private int         parameters  = 0;
   private int         attributes  = 0;
   private int         assocations = 0;
   private int         dataTypes   = 0;

   /**
    * 
    */
   public ModelStatistic(Model model) {
      super();
      this.model = model;

      new ModelVisitableIterator(new ModelVisitor() {

         public boolean visit(Model model) {
            return true;
         }

         public boolean visit(ModelPackage modelPackage) {
            ++packages;
            return true;
         }

         public boolean visit(ModelClass modelClass) {
            ++classes;
            return true;
         }

         public boolean visit(ModelAttribute attribute) {
            ++attributes;
            return true;
         }

         public boolean visit(ModelAssociation association) {
            ++assocations;
            return true;
         }

         public boolean visit(ModelMethod method) {
            ++methods;
            return true;
         }

         public boolean visit(ModelParameter parameter) {
            ++parameters;
            return true;
         }

         public boolean visit(ModelDataType dataType) {
            ++dataTypes;
            return true;
         }

         public boolean visit(ModelDependency dependency) {
            return true;
         }
      }).iterate(model);
   }

   public String toString() {
      return "Model " + model.getName() + " has\n  " + packages + " packages\n  " + classes + " classes\n  " + attributes
            + " attributes\n  " + assocations + " assocations\n  " + methods + " methods\n  " + parameters + " parameters\n  "
            + dataTypes + " datatypes";
   }
}
