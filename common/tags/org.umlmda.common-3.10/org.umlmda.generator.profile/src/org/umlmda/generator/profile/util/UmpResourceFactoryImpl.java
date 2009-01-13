/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmpResourceFactoryImpl.java,v 1.3 2005/11/08 08:06:52 moroff Exp $
 */
package org.umlmda.generator.profile.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.umlmda.generator.profile.util.UmpResourceImpl
 * @generated
 */
public class UmpResourceFactoryImpl extends ResourceFactoryImpl {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * Creates an instance of the resource factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public UmpResourceFactoryImpl() {
      super();
   }

   /**
    * Creates an instance of the resource.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Resource createResource(URI uri) {
      Resource result = new UmpResourceImpl(uri);
      return result;
   }

} //UmpResourceFactoryImpl
