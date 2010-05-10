/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.set.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the package. <!-- end-user-doc -->
 * 
 * @see org.umlmda.generator.set.util.UmsResourceImpl
 * @generated
 */
public class UmsResourceFactoryImpl extends ResourceFactoryImpl
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * Creates an instance of the resource factory. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public UmsResourceFactoryImpl() {
      super();
   }

   /**
    * Creates an instance of the resource. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public Resource createResource(URI uri) {
      Resource result = new UmsResourceImpl(uri);
      return result;
   }

} // UmsResourceFactoryImpl
