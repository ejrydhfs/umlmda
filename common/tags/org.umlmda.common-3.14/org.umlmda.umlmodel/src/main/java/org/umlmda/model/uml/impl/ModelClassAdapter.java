// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelClassAdapter.java,v 1.16.2.2 2008/04/16 09:56:19 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelClassAdapter.java,v $
// $Revision: 1.16.2.2 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/04/16 09:56:19 $
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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelGeneralization;
import org.umlmda.model.uml.ModelGeneralizationBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.ModelStructuralFeature;
import org.umlmda.model.uml.ModelVisitor;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.profile.ModelTaggedValues;

/**
 * platform independent adapter to MOF model class. extend for
 * specific platform to override the following properties: attributes,
 * constants, methods, associations
 *
 * @author vpussel
 * @author Dieter Moroff
 */
public class ModelClassAdapter extends ModelClassifierAdapter implements ModelClass {

	private final ModelClassBase modelClass;

	private ModelPackage modelPackage = null; // the package owning this class
    // Cached model information
	private List attributes = null; // list of variable attributes
	private List allAttributes = null; // list of variable attributes including super classes 
	private List constants = null; // list of constant attributes
	private List methods = null; // list of methods
	private List allMethods = null; // list of methods including super classes
	private List navigatableAssociations = null; // list navigatable of associations 
	private List associations = null; // list of associations including non navigatable
    private List allAssociations = null; // list of navigatable associations including base classes
    // Cached derived model information
    // TODO think about correct resetting
	private List referencedTypes = null; // list of referenced classes
    private List subClasses = null;
    private List allSubClasses = null;
    private List referencedBy = null;
    private List pkeyAttributes = null;
    private List ownedKeyAttributes = null;
    private List generalizations = null;
    private List superClasses = null;
    private List allSuperClasses = null;
    
	private static Comparator derivedComparator = null;
    private static Comparator hierarchyComparator = null;


	/**
	 * create adapter from ModelClass
	 */
	public ModelClassAdapter(ModelClassBase modelClass, Model model) {
		super(modelClass, model);
		this.modelClass = modelClass;
	}

	protected final ModelClassBase getModelClass() {
      return modelClass;
   }
	
      /**
       * Reset cached information 
       * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
       */
      public void update(Observable o, Object arg) {
         if ( PROPERTY_ATTRIBUTES.equals(arg) && attributes != null ) {
            attributes.clear();
            attributes = null;
            if ( allAttributes != null ) {
               allAttributes.clear();
               allAttributes = null;
            }
         }
         else if ( PROPERTY_GENERALIZATIONS.equals(arg) && generalizations != null ) {
            generalizations.clear();
            generalizations = null;
            if ( superClasses != null ) {
               superClasses.clear();
               superClasses = null;
            }
            if ( allSuperClasses != null ) {
               allSuperClasses.clear();
               allSuperClasses = null;
            }
         }
         else if ( PROPERTY_CONSTANTS.equals(arg) && constants != null ) {
            constants.clear();
            constants = null;
         }
         else if ( PROPERTY_METHODS.equals(arg) && methods != null ) {
            methods.clear();
            methods = null;
            if ( allMethods != null ) {
               allMethods.clear();
               allMethods = null;
            }
         }
         else if ( PROPERTY_ASSOCIATIONS.equals(arg) && associations != null ) {
            associations.clear();
            associations = null;
            if ( allAssociations != null ) {
               allAssociations.clear();
               allAssociations = null;
            }
         }
         else if ( PROPERTY_ALL_ASSOCIATIONS.equals(arg) && navigatableAssociations != null ) {
            navigatableAssociations.clear();
            navigatableAssociations = null;
            if ( associations != null ) {
               associations.clear();
               associations = null;
            }
            if ( allAssociations != null ) {
               allAssociations.clear();
               allAssociations = null;
            }
         }
         
      }
   
	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getPackage()
	 */
	public ModelPackage getPackage() {
		if (modelPackage == null) {
			modelPackage = adaptedModel.getModelPackage( modelClass.getPackageBase());
		}
		return modelPackage;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getPackageBase()
	 */
	public ModelPackageBase getPackageBase() {
		return getPackage();
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getAttributes()
	 */
	public List getAttributes() {
		if (attributes == null) {
			attributes = new ArrayList(modelClass.getAttributes().size());
			for (Iterator iter = modelClass.getAttributes().iterator(); iter
					.hasNext();) {
				ModelAttributeBase att = (ModelAttributeBase) iter.next();
				ModelAttribute newAtt = adaptedModel.getModelAttribute(att);
				attributes.add(newAtt);
			}
		}
		return attributes;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getConstants()
	 */
	public List getConstants() {
		if (constants == null) {
			constants = new ArrayList(modelClass.getConstants().size());
			for (Iterator iter = modelClass.getConstants().iterator(); iter
					.hasNext();) {
				ModelAttributeBase att = (ModelAttributeBase) iter.next();
				ModelAttribute newAtt = adaptedModel.getModelAttribute(att);
				constants.add(newAtt);
			}
		}
		return constants;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getAttributes(boolean)
	 */
	public List getAttributes(boolean includeBaseClasses) {
		if (includeBaseClasses) {
			if (allAttributes == null) {
				allAttributes = new ArrayList();
				for (Iterator iter = getAllSuperClasses().iterator(); iter.hasNext();) {
					ModelClass superClass = (ModelClass) iter.next();
					allAttributes.addAll(superClass.getAttributes());
				}
				allAttributes.addAll(getAttributes());
			}
			return allAttributes;
		} else {
			return getAttributes();
		}
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getMethods()
	 */
	public List getMethods() {
		if (methods == null) {
			methods = new ArrayList(modelClass.getMethods().size());
			for (Iterator iter = modelClass.getMethods().iterator(); iter
					.hasNext();) {
				ModelMethodBase method = (ModelMethodBase) iter.next();
				ModelMethod newMethod = adaptedModel.getModelMethod(method);
				methods.add(newMethod);
			}
		}
		return methods;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getMethods(boolean)
	 */
	public List getMethods(boolean includeBaseClasses) {
		if ( includeBaseClasses) {
			if (allMethods == null) {
				allMethods = new ArrayList();
				for (Iterator iter = getAllSuperClasses().iterator(); iter.hasNext();) {
					ModelClassBase superClass = (ModelClassBase) iter.next();
					allMethods.addAll(superClass.getMethods());
				}
				allMethods.addAll(getMethods());
			}
			return allMethods;
		} else {
			return getMethods();
	   }
	}

	/*
    * (non-Javadoc)
    * 
    * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getSuperClass()
    */
   public ModelClass getSuperClass() {
      ModelClass superClass = null;

      if (getGeneralizations().size() == 1) {
         superClass = ((ModelGeneralization)getGeneralizations().get(0)).getGeneral();
      }
      else {
         for (Iterator is = getGeneralizations().iterator(); is.hasNext();) {
            ModelGeneralization generalization = (ModelGeneralization) is.next();

            if ( generalization.hasStereotype(ModelStereotype.EXTENDS)) {
               superClass = generalization.getGeneral();
            }
         }
      }
      return superClass;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelClass#getSuperClasses()
    */
   public List getSuperClasses() {
      if ( superClasses == null ) {
         superClasses = new ArrayList();
         for (Iterator iter = getGeneralizations().iterator(); iter.hasNext();) {
            ModelGeneralization generalization = (ModelGeneralization) iter.next();

            superClasses.add(adaptedModel.getModelClass(generalization.getGeneral()));
         }
         Collections.sort(superClasses);
      }
      return superClasses;
   }


	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getAllSuperClasses()
	 */
	public List getAllSuperClasses() {
      if ( allSuperClasses == null ) {
         Set superClassSet = new HashSet();
         List superClasses = getSuperClasses();

         for (Iterator iter = superClasses.iterator(); iter.hasNext();) {
            ModelClass superClass = (ModelClass) iter.next();

            superClassSet.add(superClass);
         }
         getAllSuperClasses(superClasses, superClassSet);
         allSuperClasses = new ArrayList(superClassSet);
         Collections.sort(allSuperClasses, getDerivationComparator());
      }
      return allSuperClasses;
	}

	public List getConcreteClasses() {
	   List concreteClasses = new ArrayList();
	   
	   for (Iterator isc = getAllSubClasses().iterator(); isc.hasNext();) {
         ModelClass modelClass = (ModelClass) isc.next();
         
         if ( modelClass.isAbstract() == false ) {
            concreteClasses.add(modelClass);
         }
       }
	   
	   Collections.sort(concreteClasses, getHierachyComparator());
	   return concreteClasses;
	}
	
   /**
    * @param superClasses
    * @param superClassSet
    */
   private void getAllSuperClasses(Collection classes, Set superClassSet) {
      for (Iterator ic = classes.iterator(); ic.hasNext();) {
         ModelClassBase modelClassBase = (ModelClassBase) ic.next();
         ModelClass modelClass = adaptedModel.getModelClass(modelClassBase);
         Collection superClasses = modelClass.getSuperClasses();
         
         superClassSet.addAll(superClasses);
         getAllSuperClasses(superClasses, superClassSet);
      }
   }

   
	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getSubClasses()
	 */
	public List getSubClasses() {
      if ( subClasses == null ) {
         Set derivedClasses = new HashSet();
      
         getSubClasses(false, derivedClasses, this);
         subClasses = new ArrayList(derivedClasses);
         Collections.sort(subClasses, getDerivationComparator());
      }
      return subClasses;
	}

   private static void getSubClasses(boolean recursive, Set subClassSet, ModelClass modelClass) {
      Collection referencedByClass = modelClass.getReferencedBy(ModelClass.class);
      for (Iterator iter = referencedByClass.iterator(); iter.hasNext();) {
         ModelClass subClass = (ModelClass) iter.next();
         
         if ( subClassSet.add(subClass) ) {
            getSubClasses(recursive, subClassSet, subClass);
         }
      }
   }
   
	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getAllSubClasses()
	 */
	public List getAllSubClasses() {
      if ( allSubClasses == null ) {
         Set derivedClasses = new HashSet();
      
         getSubClasses(false, derivedClasses, this);
         allSubClasses = new ArrayList(derivedClasses);
         Collections.sort(allSubClasses);
      }
      return allSubClasses;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getAssociations()
	 */
	public List getAssociations() {
		if (navigatableAssociations == null) {
			navigatableAssociations = new ArrayList(modelClass.getAssociations().size());
			for (Iterator iter = modelClass.getAssociations().iterator(); iter.hasNext();) {
				ModelAssociationBase ass = (ModelAssociationBase) iter.next();
				ModelAssociation newAss = adaptedModel.getModelAssociation(ass);
				navigatableAssociations.add(newAss);
			}
			// associations are sorted per class
			Collections.sort(navigatableAssociations);
		}
		return navigatableAssociations;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getAllAssociations()
	 */
	public List getAllAssociations() {
		if (associations == null) {
			associations = new ArrayList();
			for (Iterator iter = modelClass.getAllAssociations().iterator(); iter.hasNext();) {
				ModelAssociationBase ass = (ModelAssociationBase) iter.next();
				ModelAssociation newAss = adaptedModel.getModelAssociation(ass);
				associations.add(newAss);
			}
			Collections.sort(associations, new Comparator<ModelAssociation>() {

            public int compare(ModelAssociation o1, ModelAssociation o2) {
            	String n1 = o1.getName() != null ? o1.getName() : o1.getTarget().getQualifiedName();
            	String n2 = o2.getName() != null ? o2.getName() : o2.getTarget().getQualifiedName();
            	
               return n1.compareTo(n2);
            }});
		}
		return associations;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getAssociations(boolean)
	 */
	public List getAssociations(boolean includeBaseClasses) {
		if (includeBaseClasses) {
			if (allAssociations == null) {
				allAssociations = new ArrayList();
				for (Iterator iter = getAllSuperClasses().iterator(); iter.hasNext();) {
					ModelClass superClass = (ModelClass) iter.next();
					allAssociations.addAll(superClass.getAssociations());
				}
				allAssociations.addAll(getAssociations());
			}
			return allAssociations;
		} else {
			return getAssociations();
		}
	}

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getReferencedTypes()
    */
   public List getReferencedTypes() {
      if ( referencedTypes == null ) {
         referencedTypes = getReferencedTypes(true, false);  
      }
      return referencedTypes;
   }

      /* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getReferencedTypes()
	 */
	private List getReferencedTypes(boolean includeSuperClasses, boolean allMethods) {
      final Set referencedTypeSet = new HashSet();
      
      for (Iterator iter = getAttributes().iterator(); iter.hasNext();) {
         ModelAttribute attribute = (ModelAttribute) iter.next();

         if ( attribute.getModelClassifier() != null ) {
         	addReferencedType(referencedTypeSet, attribute.getModelClassifier(), modelClass);
         }
      }

      for (Iterator iter = getAssociations().iterator(); iter.hasNext();) {
         ModelAssociation association = (ModelAssociation) iter.next();
         if (association.isNavigatableToTarget()) {
            ModelClassBase modelClass = association.getTarget();

            addReferencedType(referencedTypeSet, modelClass, this.modelClass);
         }
      }

      for (Iterator iter = getMethods(allMethods).iterator(); iter.hasNext();) {
         ModelMethod method = (ModelMethod) iter.next();

         for (Iterator ip = method.getExceptions().iterator(); ip.hasNext();) {
            ModelClass exceptionClass = (ModelClass) ip.next();
            
            addReferencedType(referencedTypeSet, exceptionClass, modelClass);
         }

         for (Iterator ip = method.getParameters().iterator(); ip.hasNext();) {
            addReferencedType(referencedTypeSet, ((ModelParameter) ip.next()).getType(), modelClass);
         }

         addReferencedType(referencedTypeSet, method.getReturnTypeBase(), modelClass);
      }
      
      if ( includeSuperClasses ) {
         for (Iterator iter = getSuperClasses().iterator(); iter.hasNext();) {
            ModelClass superClass = (ModelClass) iter.next();

            addReferencedType(referencedTypeSet, superClass, modelClass);
         }
      }
         
      List referencedTypes = new ArrayList(referencedTypeSet);
      Collections.sort(referencedTypes); 
      return referencedTypes;
	}

   protected static void addReferencedType(Set referencedTypes, ModelClassifierBase modelClassifier, ModelClassBase modelClass) {
      if ( modelClassifier instanceof ModelClass ) {
         if ( modelClassifier != modelClass )
            referencedTypes.add(modelClassifier);
      }
   }
   
	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getReferencedBy()
	 */
	public List getReferencedBy() {
      if ( referencedBy == null ) {
         Set referencedBySet = new HashSet();
         
         // Search for sub classes
         for (Iterator iter = getModel().getClasses().iterator(); iter.hasNext();) {
            ModelClass modelClass = (ModelClass) iter.next();

            for (Iterator is = modelClass.getSuperClasses().iterator(); is.hasNext();) {
               if ( this.equals(is.next())) {
                  referencedBySet.add(modelClass);
               }
            }
            
            for (Iterator iterator = modelClass.getAllAssociations().iterator(); iterator.hasNext();) {
               ModelAssociation association = (ModelAssociation) iterator.next();
               ModelAssociation reverse = association.getReverse();
               
               if ( reverse != null ) {
                  if ( this.equals(association.getTarget()) && reverse.isNavigatableToTarget() == false ) {
                     referencedBySet.add(association);
                  }
               }
               else {
                  //TODO Better exception handling
               }
            }
         }
         referencedBy = new ArrayList(referencedBySet);
         Collections.sort(referencedBy);
      }
      return referencedBy;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getReferencedBy(java.lang.Class)
	 */
	public List getReferencedBy(Class type) {
      List referencedBy = new ArrayList(getReferencedBy());
      
      for (Iterator iter = referencedBy.iterator(); iter.hasNext();) {
         ModelElementBase element = (ModelElement) iter.next();
         
         if ( type.isInstance(element) == false )
            iter.remove();
      }
      return referencedBy;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#isAbstract()
	 */
	public boolean isAbstract() {
		return modelClass.isAbstract();
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#isInheritedFrom(net.sourceforge.umlmda.xmi.uml.ModelClass)
	 */
	public boolean isInheritedFrom(ModelClass segmentClass) {
      return getAllSuperClasses().contains(segmentClass);
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getParent()
	 */
	public ModelClass getParent() {
      ModelAssociation parentComposition = getParentComposition();
      
      if ( parentComposition != null )
         return parentComposition.getSource();
      else
         return null;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getParentComposition()
	 */
	public ModelAssociation getParentComposition() {
      ModelAssociation parentComposition = null;
      
      for (Iterator iter = modelClass.getAllAssociations().iterator(); iter.hasNext();) {
         ModelAssociationBase associationBase = (ModelAssociationBase) iter.next();
         ModelAssociation association = adaptedModel.getModelAssociation(associationBase);
         ModelAssociation reverse = association.getReverse();
         
         
         if ( reverse != null ) {
            if (reverse.isComposition() && reverse.getTarget().equals(modelClass)) {
               parentComposition = reverse;
            } 
         }           
         else {
            //TODO Better exception handling
         }
      }

      // If we have one defined super class, have a look there
      if ( parentComposition == null && getSuperClass()!=null ) {
         parentComposition = getSuperClass().getParentComposition();
      }

      // Otherwise, have a look in all super classes
      if ( parentComposition == null ) {
         for (Iterator isc = getSuperClasses().iterator(); isc.hasNext();) {
            ModelClass superClass = (ModelClass) isc.next();
            
            parentComposition = superClass.getParentComposition();
            
            // Fetch the first parentComposition and live with it
            if ( parentComposition!=null ) {
               break;
            }
         }
      }
      return parentComposition;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#hasPolymorphicAssociations()
	 */
	public boolean hasPolymorphicAssociations() {
		boolean result = false;

		// polymorphic use requires existence of subclasses
		List subClasses = getAllSubClasses();
		if (subClasses.size() > 0) { 
			
			// retrieve all associations originating from or ending at current class
			for (Iterator iter = getAllAssociations().iterator(); iter.hasNext();) {
				ModelAssociation assoc = (ModelAssociation) iter.next();
				
				// search for associations with source == current class (this
				// should be always true) and that are navigatable to current class
				ModelClass source = assoc.getSource();
				if (source == this && assoc.isNavigatableToSource()) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	/** 
	 * compare classes by derivation level, base classes first
	 */
	public static Comparator getDerivationComparator() {
		if (derivedComparator == null) {
			derivedComparator = new Comparator(){
				public int compare(Object arg0, Object arg1) {
					ModelClass cls0 = (ModelClass) arg0;
					ModelClass cls1 = (ModelClass) arg1;
					int subcls0 = cls0.getAllSuperClasses().size();
					int subcls1 = cls1.getAllSuperClasses().size();
               
               if ( subcls0 != subcls1 ) {
                  return subcls0 - subcls1;
               }
               else {
                  return cls0.getQualifiedName().compareTo(cls1.getQualifiedName());
               }
				}
			};
		}
		return derivedComparator;
	}

   /** 
    * compare classes by derivation level, base classes last
    */
   public static Comparator getHierachyComparator() {
      if (hierarchyComparator == null) {
         hierarchyComparator = new Comparator(){
            public int compare(Object arg0, Object arg1) {
               ModelClass cls0 = (ModelClass) arg0;
               ModelClass cls1 = (ModelClass) arg1;
               int subcls0 = cls0.getAllSuperClasses().size();
               int subcls1 = cls1.getAllSuperClasses().size();
               
               if ( subcls0 != subcls1 ) {
                  return subcls1 - subcls0;
               }
               else {
                  return cls0.getQualifiedName().compareTo(cls1.getQualifiedName());
               }
            }
         };
      }
      return hierarchyComparator;
   }

	/**
	 * @author vpussel 
	 * 
	 * recursively resolve all class references within a schema
	 * 
	 * @param schema set of all classes already added to schema
	 * @param refClass class to be examined for additional relations
	 * @param withSubTypes true if subclasses should be examined
	 */
	private void addSchemaTypes( Set schema, ModelClass modelClass, boolean withSubtypes) {
		
      // add all association targets
      for (Iterator ia = modelClass.getAttributes().iterator(); ia.hasNext();) {
         ModelAttribute attribute = (ModelAttribute) ia.next();
         
         if ( attribute.getModelClassifier() instanceof ModelClass ) {
            if ( schema.add(attribute.getModelClassifier())) {
               addSchemaTypes( schema, (ModelClass) attribute.getModelClassifier(), true);
            }
         }
      }

        // add all association targets
		for (Iterator ia = modelClass.getAssociations().iterator(); ia.hasNext();) {
			ModelAssociation assoc = (ModelAssociation) ia.next();
			ModelClass targetClass = assoc.getTarget();
			if (schema.add( targetClass)) {
				// targetClass was not contained in schema
				// associations can be polymorphic, so we must consider subclasses  
				addSchemaTypes( schema, targetClass, true);
			}
		}
		
//		// add all super classes
//		for (Iterator isuper = modelClass.getSuperClasses().iterator(); isuper.hasNext();) {
//			ModelClass superClass = (ModelClass) isuper.next();
//			if (schema.add(superClass)) {
//				// superclass was not contained in schema
//				// superclasses are not polymorphic, ignore all other subclasses
//				addSchemaTypes( schema, superClass, false);
//			}
//		}
		// add all super classes
		for (Iterator isuper = modelClass.getGeneralizations().iterator(); isuper.hasNext();) {
		   ModelGeneralization generalization = (ModelGeneralization) isuper.next();
		   ModelClass superClass = generalization.getGeneral();
		   
		   if ( generalization.hasStereotype(ModelStereotype.EXTENDS) || modelClass.getGeneralizations().size() == 1 ) {
				if ( schema.add(superClass)) {
					// superclass was not contained in schema
					// superclasses are not polymorphic, ignore all other subclasses
					addSchemaTypes( schema, superClass, false);
				}
			}
		   else {
		      addSchemaTypes(schema, superClass, false);
		   }
		}
		
		// conditionally add all sub classes
		if (withSubtypes) {
			for (Iterator iSub = modelClass.getSubClasses().iterator(); iSub.hasNext();) {
				ModelClass subClass = (ModelClass) iSub.next();
				if (schema.add(subClass)) {
					// subclass was not contained in schema
					// subclasses are not polymorphic, ignore all other subclasses
					addSchemaTypes( schema, subClass, false);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getSchemaTypes()
	 */
	public List getSchemaTypes() {
        Collection superClasses = getSuperClasses();
		Collection refClasses = this.getReferencedTypes(true, true); 
		Set schema = new HashSet(refClasses);
		schema.add(this);
	
		for (Iterator iter = refClasses.iterator(); iter.hasNext();) {
			ModelClass mRefClass = (ModelClass) iter.next();

			addSchemaTypes(schema, mRefClass, superClasses.contains(mRefClass) == false);
		}
      
      
		List list = new ArrayList(schema.size());
		list.addAll(schema);
		Collections.sort(list);
		return list;
	}

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelClass#hasDerivedClasses()
    */
   public boolean hasDerivedClasses() {
      return getSubClasses().size() > 0;
   }

   public List getKeyAttributes() {
      if ( pkeyAttributes == null ) {
         Collection pkeyAttributes = new LinkedHashSet(getInheritedKeyAttributes());

         pkeyAttributes.addAll(getOwnedKeyAttributes(true));
         this.pkeyAttributes = new ArrayList(pkeyAttributes);
      }
      return pkeyAttributes;
   }

   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelClass#getInheritedKeyAttributes()
    */
   public List getInheritedKeyAttributes() {
      Collection parentKeyAttributes = new LinkedHashSet();
      
      // Adding key attributes of the parent classes
      ModelAssociation parentComposition = getParentComposition();
      if (parentComposition != null) {
         String inheritKeyProperty = parentComposition.getStereotypeProperty(ModelTaggedValues.DB_PKEY_INHERIT, "false");
         boolean inheritKeys = Boolean.valueOf(inheritKeyProperty).booleanValue();

         if (inheritKeys) {
            ModelClass parent = getParent();

            parentKeyAttributes.addAll(parent.getKeyAttributes());
         }
      }
      
      return new ArrayList(parentKeyAttributes);
   }

   public List getOwnedKeyAttributes(boolean includeSuperClasses) {
      Collection ownedKeyAttributes = new LinkedHashSet();

      // Adding key attributes of the base classes
      if (includeSuperClasses) {
         for (Iterator iter = getSuperClasses().iterator(); iter.hasNext();) {
            ModelClass superClass = (ModelClass) iter.next();

            ownedKeyAttributes.addAll(superClass.getOwnedKeyAttributes(true));
         }
      }

      // Adding key attributes of the own classes
      for (Iterator iter = getAttributes().iterator(); iter.hasNext();) {
         ModelAttribute attribute = (ModelAttribute) iter.next();

         if (attribute.hasStereotype(ModelStereotype.ATTRIBUTE_PKEY)) {
            ownedKeyAttributes.add(attribute);
         }
      }
      return new ArrayList(ownedKeyAttributes);
      
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitable#accept(org.umlmda.model.uml.ModelVisitor)
    */
   public void accept(ModelVisitor visitor) {
      visitor.visit(this);
   }

   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelClass#getAllAssociations(boolean)
    */
   public List getAllAssociations(boolean includeBaseClasses) {
      if ( includeBaseClasses ) {
         List allAssociations = new ArrayList(getAllAssociations());
         
         for (Iterator is = getAllSuperClasses().iterator(); is.hasNext();) {
            ModelClass superClass = (ModelClass) is.next();
            
            allAssociations.addAll(superClass.getAllAssociations());
         }
         
         return allAssociations;
      }
      else {
         return getAllAssociations();
      }
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelClass#getContainments()
    */
   public Collection getParentCompositions() {
      List containments = new ArrayList();
      
      for (Iterator iter = getAllAssociations(true).iterator(); iter.hasNext();) {
         ModelAssociationBase associationBase = (ModelAssociationBase) iter.next();
         ModelAssociation association = adaptedModel.getModelAssociation(associationBase);
         ModelAssociation reverse = association.getReverse();
         
         if ( reverse.isComposition() ) {
            containments.add(reverse);
         } 
      }

      return containments;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelClassBase#getGeneralizations()
    */
   public List getGeneralizations() {
		if (generalizations == null) {
		   generalizations = new ArrayList();
			for (Iterator iter = modelClass.getGeneralizations().iterator(); iter.hasNext();) {
				ModelGeneralizationBase gen = (ModelGeneralizationBase) iter.next();
				ModelGeneralization newAss = adaptedModel.getModelGeneralization(gen);
				generalizations.add(newAss);
			}
			Collections.sort(generalizations);
		}
		return generalizations;
   }
   
   /**
    * Returns an alphabetical sorted list of all classes contained in the inheritance tree
    * of the class.
    * @param modelClass
    * @return
    */
   public List getInheritanceTree() {
      Set inheritanceSet = new HashSet(getAllSuperClasses());
      
      inheritanceSet.add(this);
      for (Iterator iter = getAllSubClasses().iterator(); iter.hasNext();) {
         ModelClass subClass = (ModelClass) iter.next();
         
         if ( inheritanceSet.add(subClass)) {
            for (Iterator is = subClass.getAllSuperClasses().iterator(); is.hasNext();) {
               ModelClass superClass = (ModelClass) is.next();
               
               inheritanceSet.add(superClass);
            }
         }
      }
      
      List inheritanceTree = new ArrayList(inheritanceSet);
      
      Collections.sort(inheritanceTree);
      return inheritanceTree;
   }

   public boolean hasNoneGenerateableFeatures() {
      return isNoneGenerateableFeaturesOwned();
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelClass#hasNoneGenerateableFeatures()
    */
   public boolean isNoneGenerateableFeaturesOwned() {
      boolean derivedFeatures = false;
      
      if ( getMethods().size() == 0 ) {
         for (Iterator iattr = getAttributes().iterator(); derivedFeatures == false && iattr.hasNext();) {
            ModelStructuralFeature feature = (ModelStructuralFeature) iattr.next();

            if (feature.isDerived()) {
               derivedFeatures = true;
            }
         }

         for (Iterator iassoc = getAssociations().iterator(); derivedFeatures == false && iassoc.hasNext();) {
            ModelStructuralFeature feature = (ModelStructuralFeature) iassoc.next();

            if (feature.isDerived()) {
               derivedFeatures = true;
            }
         }
      }
      
      return derivedFeatures || getMethods().size() > 0;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelClass#getAbstractBaseClassesWithNoneGenerateableFeatures()
    */
   public List getAbstractBaseClassesWithNoneGenerateableFeatures() {
      Set classSet = new HashSet();
      
      for (Iterator isc = getSuperClasses().iterator(); isc.hasNext();) {
         ModelClass superClass = (ModelClass) isc.next();
         
         if ( superClass.isNoneGenerateableFeaturesOwned() ) {
            classSet.add(superClass);
         }
         if ( superClass.isAbstract()) {
            classSet.addAll(superClass.getAbstractBaseClassesWithNoneGenerateableFeatures());
         }
      }
      
      List result = new ArrayList(classSet);
      Collections.sort(result);
      return result;
   }
   
}
