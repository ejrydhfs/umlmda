/*
 *  Copyright (C) 2003, 2004 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://umlmda.sf.net)
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
 *  Created on 27.09.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.j2ee;

import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelPackage;

import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.java.JavaModelAdapter;

/**
 * @author moroff
 */
public class J2EEModelAdapter extends JavaModelAdapter implements J2EEModel
{

   public static final String PROPERTY_J2EE_SPEC                        = "J2EESpec";
   public static final String PROPERTY_DEFAULT_J2EE_SPEC                = "2.1";
   public static final String PROPERTY_JNDI_REPLACEMENT_PATTERN         = "JNDIReplacementPattern";
   public static final String PROPERTY_DEFAULT_JNDI_REPLACEMENT_PATTERN = "(.*)";
   public static final String PROPERTY_JNDI_REPLACEMENT                 = "JNDIReplacement";
   public static final String PROPERTY_DEFAULT_JNDI_REPLACEMENT         = "env/$1Bean";
   public static final String PROPERTY_JNDI_NAME                        = "JNDIName";

   /**
    * @param factory
    * @param srcModel
    */
   public J2EEModelAdapter(ModelAdapterFactory factory, ModelBase srcModel) {
      super(factory, srcModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.j2ee.J2EEModel#getJNDIReplacementPattern()
    */
   public String getJNDIName() {
      return getProperties().getProperty(PROPERTY_JNDI_NAME);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.j2ee.J2EEModel#getJNDIReplacementPattern()
    */
   public String getJNDIReplacementPattern() {
      return getProperties().getProperty(PROPERTY_JNDI_REPLACEMENT_PATTERN, PROPERTY_DEFAULT_JNDI_REPLACEMENT_PATTERN);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.j2ee.J2EEModel#getJNDIReplacement()
    */
   public String getJNDIReplacement() {
      return getProperties().getProperty(PROPERTY_JNDI_REPLACEMENT, PROPERTY_DEFAULT_JNDI_REPLACEMENT);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.j2ee.J2EEModel#getJ2EESpec()
    */
   public String getJ2EESpec() {
      return getProperties().getProperty(PROPERTY_J2EE_SPEC, PROPERTY_DEFAULT_J2EE_SPEC);
   }

   /**
    * Create common elements used in the writers for the java plattform.
    */
   protected void createCommonModelElements() {
      // Create common java classes
      ModelPackage javax = (ModelPackage) find("javax");
      if ( javax == null ) {
         javax = createPackage("javax", getModel());
      }
      ModelPackage javaxJms = (ModelPackage) find("javax.jms");
      if ( javaxJms == null ) {
         javaxJms = createPackage("jms", javax);
      }
      ModelClass javaxJmsQueue = (ModelClass) find("javax.jms.Queue");
      if ( javaxJmsQueue == null ) {
         javaxJmsQueue = createClass("Queue", javaxJms, ModelStereotype.NATIVE_CLASS);
      }
   }

}
