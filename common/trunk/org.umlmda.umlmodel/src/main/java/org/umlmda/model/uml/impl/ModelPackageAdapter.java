// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelPackageAdapter.java,v 1.4 2006/04/13 23:04:37 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelPackageAdapter.java,v $
// $Revision: 1.4 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/04/13 23:04:37 $
//   $Locker:  $
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
 * platform independent adapter to MOF model package.
 * extend for specific platform to override the following properties:
 * classes, referenced packages, parent package, base name
 *
 * @author vpussel
 *
 */
public class ModelPackageAdapter extends ModelElementAdapter implements ModelPackage {

	private final ModelPackageBase modelPackage;
	private List classes = null;
	private List referencedPkgs = null;
	private List referencedClasses = null;
	private ModelPackage parentPkg = null;

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
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    public void update(Observable o, Object arg) {
       if ( PROPERTY_CLASSES.equals(arg) && classes != null ) {
          classes.clear();
          classes = null;
       }
    }
   
   
	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelPackage#getClasses()
	 */
	public List getClasses() {
		if (classes == null) {
			classes = new ArrayList();
			// copy class list in package
			for (Iterator iter = modelPackage.getClasses().iterator(); iter.hasNext();) {
				ModelClassBase cls = (ModelClassBase)iter.next();
				ModelClass newCls = adaptedModel.getModelClass(cls);
				classes.add(newCls);
			}
			Collections.sort(classes);
		}
		return classes;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelPackage#getReferencedPackages()
	 */
	public List getReferencedPackages() {
		if (referencedPkgs == null) {
			referencedPkgs = new ArrayList();
			
			Set set = new HashSet();
			for (Iterator ic = getClasses().iterator(); ic.hasNext();) {
				ModelClass modelClass = (ModelClass) ic.next();
		            
				for (Iterator icr = modelClass.getReferencedTypes().iterator(); icr.hasNext();) {
					ModelClass refModelClass = (ModelClass)icr.next();
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

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelPackage#getPackage()
	 */
	public ModelPackage getPackage() {
		if (parentPkg == null) {
			parentPkg = adaptedModel.getModelPackage(modelPackage.getPackageBase());
		}
		return parentPkg;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelPackageBase#getPackageBase()
	 */
	public ModelPackageBase getPackageBase() {
		return getPackage();
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelPackage#getReferencedClasses()
	 */
	public List getReferencedClasses() {
		if (referencedClasses == null) {
			referencedClasses = new ArrayList();
         Set referencedTypes = new HashSet();

         for (Iterator iter = getClasses().iterator(); iter.hasNext();) {
            ModelClass mClass = (ModelClass) iter.next();
         
            if ( mClass.getPackage() != modelPackage )
               referencedTypes.add(mClass);
         }
         referencedClasses.addAll(referencedTypes);
         Collections.sort(referencedClasses);
      }      
      return referencedClasses;
	}

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackage#getClasses(java.lang.String)
    */
   public List getClasses(String stereotype) {
      List classes = new ArrayList();
      
      for (Iterator ic = getClasses().iterator(); ic.hasNext();) {
         ModelClass modelClass = (ModelClass) ic.next();
         
         if ( modelClass.hasStereotype(stereotype))
            classes.add(modelClass);
      }
      return classes;
   }
   

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitable#accept(org.umlmda.model.uml.ModelVisitor)
    */
   public void accept(ModelVisitor visitor) {
      visitor.visit(this);
   }
}
