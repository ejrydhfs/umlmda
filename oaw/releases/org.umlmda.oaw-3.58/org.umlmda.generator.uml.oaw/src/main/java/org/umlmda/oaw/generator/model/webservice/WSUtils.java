package org.umlmda.oaw.generator.model.webservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.webservices.WSModelClass;
import org.umlmda.uml.generator.webservices.WSModelPackage;

public class WSUtils {

	@SuppressWarnings("unchecked")
	public static List<WSModelPackage> getPackages(WSModelClass wsModelClass) {
		return wsModelClass.getReferencedPackages();
	}

	@SuppressWarnings("unchecked")
	public static List<WSModelClass> getReferencedClasses(WSModelClass wsModelClass) {
		return wsModelClass.getReferencedClasses();
	}

	@SuppressWarnings("unchecked")
	public static List<WSModelClass> getReferencedClasses(WSModelClass wsModelClass, WSModelPackage modelPackage) {
		return wsModelClass.getReferencedClasses(modelPackage);
	}

	/**
	 * Checks if a hierarchieclass has to be created
	 * 
	 * @param modelClass
	 * @return
	 */
	public static boolean hasHierarchie(WSModelClass wsModelClass, ModelClass modelClass) {
		return (hasDerivedClasses(modelClass) && usedAsParameterOrReference(wsModelClass, modelClass));
	}

	public static boolean hasDerivedClasses(ModelClass modelClass) {
		return modelClass.getReferencedBy(ModelClass.class).size() > 0;
	}

	/**
	    * 
	    */
	public static Collection<WSModelClass> getDerivedClasses(ModelClass modelClass) {
		Set<WSModelClass> derivedClassSet = new HashSet<WSModelClass>();

		getDerivedClasses(derivedClassSet, modelClass);
		List<WSModelClass> derivedClasses = new ArrayList<WSModelClass>(derivedClassSet);
		Collections.sort(derivedClasses, new Comparator<ModelClass>() {

			public int compare(ModelClass mc1, ModelClass mc2) {
				if (mc1.isInheritedFrom(mc2))
					return -1;
				else if (mc2.isInheritedFrom(mc1))
					return 1;
				else
					return mc1.getQualifiedName().compareTo(
							mc2.getQualifiedName());
			}
		});
		return derivedClasses;
	}

	public static boolean hasDerivedOptimizedClasses(ModelClass modelClass) {
		return ((WSModelClass) modelClass).hasDerivedOptimizedClasses();
	}

	private static void getDerivedClasses(Set derivedClasses,
			ModelClass modelClass) {
		if (modelClass.isAbstract() == false) {
			derivedClasses.add(modelClass);
		}
		for (Iterator iter = modelClass.getSubClasses().iterator(); iter
				.hasNext();) {
			ModelClass derivedClass = (ModelClass) iter.next();

			if (derivedClass.isAbstract() == false) {
				if (derivedClasses.add(derivedClass)) {
					getDerivedClasses(derivedClasses, derivedClass);
				}
			}
		}
	}

//	public static String getTypeOrHierarchie(ModelClassifier modelClassifier) {
//		return getTypeOrHierarchie(modelClassifier, "");
//	}

//	public static String getTypeOrHierarchie(ModelClassifier modelClassifier, String direction) {
//		if (modelClassifier instanceof ModelClass && hasDerivedClasses((ModelClass) modelClassifier)) {
//			ModelClass modelClass = (ModelClass) modelClassifier;
//			if (StringUtils.isNotEmpty(direction) && (isOptimized(modelClass) || hasDerivedOptimizedClasses(modelClass)))
//				return getType(modelClass) + direction + "Hierarchie";
//			else
//				return getType(modelClass) + "Hierarchie";
//		} else if (modelClassifier instanceof ModelClass) {
//			return getDirectionType((ModelClass) modelClassifier, direction);
//		} else {
//			return getType(modelClassifier);
//		}
//	}

	static public boolean isOptimized(ModelClass modelClass) {
		return ((WSModelClass) modelClass).isOptimized();
	}

//	public static String getDirectionType(ModelClass modelClass, String direction) {
//		String type = getType(modelClass);
//		if (StringUtils.isEmpty(direction) == false && isOptimized(modelClass)) {
//			return type + direction;
//		} else {
//			return type;
//		}
//	}

	public static boolean usedAsParameter(WSModelClass modelClass, ModelClass parameterClass) {
		boolean usedAsParameter = false;

		for (Iterator<ModelMethod> im = modelClass.getMethods(true).iterator(); !usedAsParameter && im.hasNext();) {
			ModelMethod method = im.next();

			for (Iterator<ModelParameter> ip = method.getParameters().iterator(); !usedAsParameter && ip.hasNext();) {
				ModelParameter parameter = ip.next();

				if (parameter.getType() == parameterClass)
					usedAsParameter = true;
			}

			for (Iterator<ModelClass> ie = method.getExceptions().iterator(); !usedAsParameter && ie.hasNext();) {
				ModelClass exception = ie.next();

				if (exception == parameterClass)
					usedAsParameter = true;
			}

			if (method.getReturnType() == parameterClass)
				usedAsParameter = true;
		}

		return usedAsParameter;
	}

	public static boolean usedAsParameterOrReference(WSModelClass modelClass, ModelClass parameterOrRefClass) {
		boolean usedAsParameter = usedAsParameter(modelClass, parameterOrRefClass);

		for (Iterator<WSModelClass> ic = getReferencedClasses(modelClass).iterator(); !usedAsParameter && ic.hasNext();) {
			ModelClass modelClass2 = (ModelClass) ic.next();

			for (Iterator<ModelAttribute> ia = modelClass2.getAttributes().iterator(); !usedAsParameter && ia.hasNext();) {
				ModelAttribute attribute = (ModelAttribute) ia.next();

				if (attribute.getModelClass() == parameterOrRefClass)
					usedAsParameter = true;
			}

			for (Iterator<ModelAssociation> ia = modelClass2.getAssociations().iterator(); !usedAsParameter && ia.hasNext();) {
				ModelAssociation association = (ModelAssociation) ia.next();

				if (association.getTarget() == parameterOrRefClass)
					usedAsParameter = true;
			}
		}
		return usedAsParameter;
	}

	public static boolean matchDirection(ModelElement modelElement, String direction) {
		if (direction.equals(ModelStereotype.DIRECTION_IN)) {
			return modelElement.hasStereotype(ModelStereotype.DIRECTION_OUT) == false;
		} else if (direction.equals(ModelStereotype.DIRECTION_OUT)) {
			return modelElement.hasStereotype(ModelStereotype.DIRECTION_IN) == false;
		} else
			return true;
	}

//	public static String getFactoryMember(ModelPackage modelPackage) {
//		String factoryMember = (String) factoryMemberMap.get(modelPackage);
//
//		if (factoryMember == null) {
//			factoryMember = "factory" + (factoryMemberMap.size() + 1);
//			factoryMemberMap.put(modelPackage, factoryMember);
//		}
//
//		return factoryMember;
//	}

}
