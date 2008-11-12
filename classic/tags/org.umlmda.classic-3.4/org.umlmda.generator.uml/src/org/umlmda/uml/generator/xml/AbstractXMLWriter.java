/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/xml/AbstractXMLWriter.java,v 1.5 2006/07/10 15:37:10 moroff Exp $
 *  Copyright (C) 2005 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://www.umlmda.org)
 *
 *  UMLMDA is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 * 
 *  UMLMDA is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  General Public License for more details.
 * 
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with UMLMDA; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *  02111-1307, USA.
 *
 *  Created on Jun 14, 2005
 */
package org.umlmda.uml.generator.xml;

import java.beans.Introspector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.impl.ModelClassAdapter;

import org.umlmda.generator.AbstractModelElementWriter;
import org.umlmda.generator.AbstractPackageWriter;
import org.umlmda.generator.model.util.DefaultClassHelper;
import org.umlmda.generator.model.util.DefaultMethodHelper;
import org.umlmda.profile.ModelStereotype;

/**
 * base class for writer generating XML schema for a business component
 * 
 * @author vpussel
 */
public abstract class AbstractXMLWriter extends AbstractPackageWriter {
   
	private static final String NS_PREFIX = "tns1:";
	private String namespacePrefix = NS_PREFIX;
	private String targetNamespace = null;
	private List rootTypes = null; 
	private List complexTypes = null;
	private List serviceTypes = null;
	private List assocTypes = null;
	private List polymorphTypes = null;

	public AbstractXMLWriter() {
      super(new DefaultClassHelper(), new DefaultMethodHelper());
   }
   
	/**
	 * return the namespace prefix
	 */
	public String getNamespacePrefix() {
		return namespacePrefix;
	}
	/**
	 * set the namespace prefix
	 * @param namespacePrefix
	 */
	public void setNamespacePrefix(String namespacePrefix) {
		this.namespacePrefix = namespacePrefix;
	}

	/**
	 * @return Returns the targetNamespace.
	 */
	public String getTargetNamespace() {
		if (targetNamespace == null) {
			StringBuffer domain = new StringBuffer("www");
			String name = getModelPackage().getName();
			for (ModelPackage owner = getModelPackage().getPackage(); owner != null && owner.getPackage() != null; owner = owner.getPackage()) {
				if (owner.getPackage().hasStereotype("Domain Package")) {
					domain.append(".");
					domain.append(owner.getName());
					domain.append(".");
					domain.append(owner.getPackage().getName());
					break;
				}
				name = owner.getName() + "/" + name;	
			}
			targetNamespace = domain + "/" + name;
		}
		return targetNamespace;
	}

	/**
	 * return a list of classes which occur as parameter or as return type in the business service interfaces
	 */
	public List getServiceTypes() {
		if (serviceTypes == null) {
			Set refTypes = new HashSet();
			for( Iterator iter = getModelPackage().getClasses().iterator(); iter.hasNext(); ) {
				ModelClass cls = (ModelClass) iter.next();
				if (cls.hasStereotype(ModelStereotype.BUSINESS_SERVICE)) {
					for (Iterator im = cls.getMethods().iterator(); im.hasNext();) {
						ModelMethod method = (ModelMethod) im.next();
						for (Iterator ip = method.getParameters().iterator(); ip.hasNext();) {
							ModelParameter parm = (ModelParameter) ip.next();
							ModelClassifier classif = parm.getType();
							if (classif instanceof ModelClass) {
								refTypes.add(classif);
							}
						}
						ModelClassifier classif = method.getReturnType();
						if (classif instanceof ModelClass) {
							refTypes.add(classif);
						}
					}
				}
			}
			serviceTypes = new ArrayList(refTypes);
			Collections.sort(serviceTypes);
		}
		return serviceTypes;
	}

	/**
	 * return all types to be added to the root element in XML schema
	 */
	public List getRootTypes() {
		if (rootTypes == null) {
			Set refTypes = new HashSet(); 
			for (Iterator iter = getServiceTypes().iterator(); iter.hasNext();) {
				ModelClass cls = (ModelClass) iter.next();

				// add the class itself
				refTypes.add(cls);

				// add types that are referenced via associations from this class
				for (Iterator ia = cls.getAssociations(true).iterator(); ia.hasNext();) {
					ModelAssociation assoc = (ModelAssociation) ia.next();
					if (assoc.isNavigatableToTarget()) {
						ModelClass clsTarget = assoc.getTarget();
						refTypes.add(clsTarget);
					}
				}
			}
			rootTypes = new ArrayList(refTypes);
			Collections.sort(rootTypes);
		}
		return rootTypes;
	}

	/**
	 * return all business object classes that are targeted by navigatable associations
	 */
	public List getAssocTypes() {
		if (assocTypes == null) {
			Set set = new HashSet();
			
			// iterate all business objects classes
			for (Iterator iter = getModelPackage().getClasses().iterator(); iter.hasNext();) {
				ModelClass cls = (ModelClass) iter.next();
				if (!cls.hasStereotype(ModelStereotype.BUSINESS_OBJECT))
					continue;

				// iterate all navigatable associations
				for (Iterator ia = cls.getAssociations().iterator(); ia.hasNext();) {
					ModelAssociation assoc = (ModelAssociation) ia.next();
					if (!assoc.isNavigatableToTarget())
						continue;
					
					ModelClass clsTarget = assoc.getTarget();

					// examine association target
					if (!clsTarget.hasStereotype(ModelStereotype.BUSINESS_OBJECT))
						continue;
						
					// we have a target business object class
					set.add(clsTarget);
				}
			}
			assocTypes = new ArrayList(set);
			Collections.sort(assocTypes);
		}
		return assocTypes;
	}
	
	/**
	 * return the list of business objects that appear in the XML schema
	 */
	public List getComplexTypes() {
		if (complexTypes == null) {
			Set refTypes = new HashSet();
			ModelClass cls = null;
			for (Iterator iter = getRootTypes().iterator(); iter.hasNext();) {
				cls = (ModelClass) iter.next();
				
				// add the class itself
				if (cls.hasStereotype(ModelStereotype.BUSINESS_OBJECT))
					refTypes.add(cls);

				// add types that are referenced via associations from this class
				for (Iterator it = cls.getReferencedTypes().iterator(); it.hasNext();) {
					ModelClass clsRef = (ModelClass) it.next();
					if (clsRef.hasStereotype(ModelStereotype.BUSINESS_OBJECT))
						refTypes.add(clsRef);
				}

				// add subclasses of this class
				for (Iterator it = cls.getAllSubClasses().iterator(); it.hasNext();) {
					ModelClass clsRef = (ModelClass) it.next();
					if (clsRef.hasStereotype(ModelStereotype.BUSINESS_OBJECT))
						refTypes.add(clsRef);
				}

				// add superclasses of this class
				for (Iterator it = cls.getAllSuperClasses().iterator(); it.hasNext();) {
					ModelClass clsRef = (ModelClass) it.next();
					if (clsRef.hasStereotype(ModelStereotype.BUSINESS_OBJECT))
						refTypes.add(clsRef);
				}
			}
			complexTypes = new ArrayList(refTypes);

         if ( complexTypes.size() > 1  && cls != null ) {
            Collections.sort(complexTypes, ModelClassAdapter.getDerivationComparator());
         }
		}	
		return complexTypes;
	}
	
	/**
	 * find the base classes that are used as base/derived classes
	 * @return
	 */
	public List getPolymorphTypes() {
		if (polymorphTypes == null) {
			Set set = new HashSet();
			
			for (Iterator icls = getComplexTypes().iterator(); icls.hasNext();) {
				ModelClass cls = (ModelClass) icls.next();

				// if class not targeted by association, passed as parameter or as return type: forget it
				if (!getAssocTypes().contains(cls) && !getServiceTypes().contains(cls))
					continue;

				// check base classes
				for (Iterator isub = cls.getAllSubClasses().iterator(); isub.hasNext();) {
					ModelClass subCls = (ModelClass) isub.next();
					
					// if subclass not targeted by association, passed as parameter or as return type: forget it
					if (getAssocTypes().contains(subCls) && !getServiceTypes().contains(cls))
						continue;
					
					// here we have polymorphic use
					set.add(cls);
				}
			}
			polymorphTypes = new ArrayList(set);
			Collections.sort(polymorphTypes);
		}
		return polymorphTypes;
	}
	
	public ModelClass getPolymorphBase(ModelClass cls) {
		ModelClass result = null;
		if (getPolymorphTypes().contains(cls))
			result = cls;
		else {
			for (Iterator iter = cls.getAllSuperClasses().iterator(); iter.hasNext();) {
				ModelClass superCls = (ModelClass) iter.next();
				if (getPolymorphTypes().contains(superCls)) {
					result = superCls;
					break;
				}
			}
		}
		return result;
	}
	/**
	 * check if a type is polymorph
	 */
	public boolean isPolymorph(ModelClass cls, int nm) {
		boolean result = false;
		switch(nm) {
		case NM_BASE:
			result = getPolymorphTypes().contains(cls);
			break;
		case NM_DERIVED:
			ModelClass tmp = getPolymorphBase(cls);
			result = (tmp != null) && (tmp != cls);
			break;
		case NM_ANY:
			ModelClass tmp2 = getPolymorphBase(cls);
			result = (tmp2 != null);
		}
		return result;
	}

	public static final int NM_PLAIN = 1;
	public static final int NM_BASE = 10;
	public static final int NM_DERIVED = 11;
	public static final int NM_ANY = 12;
	public static final int NM_QREF_BASE = 20;
	public static final int NM_QREF_DERIVED = 21;
	public static final int NM_BEAN = 30;

	/**
	 * return the type names of a business object class
	 */
	public String getName(ModelClass cls, int nm) {
		StringBuffer result = new StringBuffer();
		
		switch (nm) {
		case NM_PLAIN:
			// return the unqualified class name without suffixes
			result.append( cls.getName());
			break;
		case NM_BASE:
			// return the definition base name  
			// any definition inherits the global XML schema target namespace
			// - thus omit the namespace qualifier 
			result.append( cls.getName());
			result.append( isPolymorph(cls, NM_BASE) ? "Base" : "Type");
			break;
		case NM_DERIVED:
			// return the definition derived name  
			// no namespace
			result.append( cls.getName() + "Type");
			break;
		case NM_QREF_BASE:
			// return the qualified reference of a base type
			result.append( getNamespacePrefix());
			result.append( cls.getName());
			result.append( isPolymorph(cls, NM_BASE) ? "Base" : "Type");
			break;
		case NM_QREF_DERIVED:
			// return the qualified reference of a derived type
			result.append( getNamespacePrefix());
			result.append( cls.getName() + "Type");
			break;
		case NM_BEAN:
			// return the bean name
			result.append( Introspector.decapitalize(cls.getName()));
			break;
		}

		// strip underscores from XML class names
		for (int ii = 0; ii < result.length(); ii ++)
			if (result.charAt(ii) == '_')
				result.deleteCharAt(ii);
		return result.toString();
	}
	
	public static final int NM_GETTER = 100;
	public static final int NM_SETTER = 101;

	/**
	 * return the getter/setter for associations
	 */
	public String getName(ModelAssociation assoc, int nm) {
		StringBuffer result = new StringBuffer();
		
		switch (nm) {
		case NM_GETTER:
			result.append( AbstractModelElementWriter.getter(assoc));
			break;
		case NM_SETTER:
			result.append( AbstractModelElementWriter.setter(assoc));
			break;
		} // switch

		// strip underscores from XML class names
		for (int ii = 0; ii < result.length(); ii ++)
			if (result.charAt(ii) == '_')
				result.deleteCharAt(ii);
		return result.toString();
	}

	/**
	 * return the getter/setter for attributes
	 */
	public String getName(ModelAttribute attr, int nm) {
		StringBuffer result = new StringBuffer();
		
		switch (nm) {
		case NM_GETTER:
			result.append( AbstractModelElementWriter.getter(attr));
			break;
		case NM_SETTER:
			result.append( AbstractModelElementWriter.setter(attr));
			break;
		} // switch

		// strip underscores from XML class names
		for (int ii = 0; ii < result.length(); ii ++)
			if (result.charAt(ii) == '_')
				result.deleteCharAt(ii);
		return result.toString();
	}
}
