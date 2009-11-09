// UMLMDA, UMLModel-API
// 
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Library General Public
//  License as published by the Free Software Foundation; either
//  version 2 of the License, or (at your option) any later version.
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Library General Public License for more details.
//
//  You should have received a copy of the GNU Library General Public
//  License along with this library; if not, write to the
//  Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//  Boston, MA  02111-1307, USA. The text of license can be also found
//  at http://www.gnu.org/copyleft/lgpl.html
//
// Created on Jun 7, 2005
package org.umlmda.model.uml.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.ModelVisitor;

/**
 * Platform independent adapter to MOF model package. Extend for specific platform to override the following properties: classes,
 * referenced packages, parent package, base name
 * 
 * @author vpussel
 */
public class ModelPackageAdapter extends ModelElementAdapter implements ModelPackage
{

   private final ModelPackageBase  modelPackage;
   private List                    classes           = null;
   private List                    referencedPkgs    = null;
   private ArrayList<ModelPackage> nestedPackages    = null;
   private List<ModelClass>        referencedClasses = null;
   private ModelPackage            parentPkg         = null;

   /**
    * create a model package
    */
   public ModelPackageAdapter(ModelPackageBase modelPackage, Model modelAdapter) {

      // create ModelElement base class
      super(modelPackage, modelAdapter);

      this.modelPackage = modelPackage;
      // filled on demand:
      // classes, referencedPkgs, parentPkgm, basename
   }

   /**
    * Reset cached information
    * 
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      if ( PROPERTY_CLASSES.equals(arg) && classes != null ) {
         classes.clear();
         classes = null;
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackageBase#getClasses()
    */
   public List getClasses() {
      if ( classes == null ) {
         classes = new ArrayList<ModelClass>();
         // copy class list in package
         for ( Iterator<ModelClass> iter = modelPackage.getClasses().iterator(); iter.hasNext(); ) {
            ModelClassBase cls = iter.next();
            ModelClass newCls = adaptedModel.getModelClass(cls);
            classes.add(newCls);
         }
         Collections.sort(classes);
      }
      return classes;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackage#getReferencedPackages()
    */
   public List<ModelPackageBase> getReferencedPackages() {
      if ( referencedPkgs == null ) {
         referencedPkgs = new ArrayList();

         Set<ModelPackageBase> set = new HashSet<ModelPackageBase>();
         for ( Iterator<ModelClass> ic = getClasses().iterator(); ic.hasNext(); ) {
            ModelClass modelClass = ic.next();

            for ( Iterator icr = modelClass.getReferencedTypes().iterator(); icr.hasNext(); ) {
               ModelClass refModelClass = (ModelClass) icr.next();
               ModelPackageBase refModelPackage = refModelClass.getPackage();
               if ( refModelPackage != this )
                  set.add(refModelPackage);
            }
         }
         referencedPkgs.addAll(set);
         Collections.sort(referencedPkgs);
      }
      return referencedPkgs;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackage#getPackage()
    */
   public ModelPackage getPackage() {
      if ( parentPkg == null ) {
         parentPkg = adaptedModel.getModelPackage(modelPackage.getPackageBase());
      }
      return parentPkg;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackageBase#getPackageBase()
    */
   public ModelPackageBase getPackageBase() {
      return getPackage();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackage#getReferencedClasses()
    */
   public List<ModelClass> getReferencedClasses() {
      if ( referencedClasses == null ) {
         referencedClasses = new ArrayList<ModelClass>();
         Set<ModelClass> referencedTypes = new HashSet<ModelClass>();

         for ( Iterator<ModelClass> iter = getClasses().iterator(); iter.hasNext(); ) {
            ModelClass mClass = iter.next();

            if ( mClass.getPackage() != modelPackage )
               referencedTypes.add(mClass);
         }
         referencedClasses.addAll(referencedTypes);
         Collections.sort(referencedClasses);
      }
      return referencedClasses;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackage#getClasses(java.lang.String)
    */
   public List getClasses(String stereotype) {
      List<ModelClass> classes = new ArrayList<ModelClass>();

      for ( Iterator<ModelClass> ic = getClasses().iterator(); ic.hasNext(); ) {
         ModelClass modelClass = ic.next();

         if ( modelClass.hasStereotype(stereotype) )
            classes.add(modelClass);
      }
      return classes;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitable#accept(org.umlmda.model.uml.ModelVisitor)
    */
   public void accept(ModelVisitor visitor) {
      visitor.visit(this);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackage#getNestedPackages()
    */
   public List<? extends ModelPackageBase> getNestedPackages() {
      if ( nestedPackages == null ) {
         nestedPackages = new ArrayList<ModelPackage>();

         // copy class list in package
         for ( Iterator iter = modelPackage.getNestedPackagesBase().iterator(); iter.hasNext(); ) {
            ModelPackageBase nestedPackageBase = (ModelPackageBase) iter.next();
            ModelPackage nestedPackage = adaptedModel.getModelPackage(nestedPackageBase);
            nestedPackages.add(nestedPackage);
         }
      }
      return nestedPackages;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackageBase#getNestedPackagesBase()
    */
   public List<? extends ModelPackageBase> getNestedPackagesBase() {
      return getNestedPackages();
   }
}
