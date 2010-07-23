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
 *  Created on 08.08.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.j2ee;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.umlmda.generator.model.util.GeneratorRuntime;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.generator.model.util.StringUtil.PatternNotMatchException;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.java.JavaModelClassAdapter;

/**
 * @author MOROFF
 */
public class J2EEModelClassAdapter extends JavaModelClassAdapter implements J2EEModelClass
{
   private String jndiName = null;

   /**
    * @param modelClassBase
    * @param model
    */
   public J2EEModelClassAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.j2ee.J2EEModelClass#getJndiName()
    */
   public String getJndiName() {
      if ( jndiName == null ) {
         J2EEModelPackage genPackage = (J2EEModelPackage) getGeneratorPackage();
         J2EEModel genModel = (J2EEModel) genPackage.getGeneratorModel();
         String nameBase = genPackage.getComponent() + "/" + getName();
         String pattern = genModel.getJNDIReplacementPattern();
         String replacement = genModel.getJNDIReplacement();
         String jndiNameTemplate = genModel.getJNDIName();

         if ( jndiNameTemplate == null ) {
            try {
               jndiName = StringUtil.regexReplacement(nameBase, pattern, replacement);
            }
            catch (PatternNotMatchException e) {
               jndiName = nameBase;
            }
         }
         else {
            // Prepare the model
            Context model = new VelocityContext();

            model.put("genClass", this);
            model.put("componentValues", getComponent().getTaggedValues());

            VelocityEngine engine = GeneratorRuntime.getInstance().createVelocityEngine();

            try {
               engine.init(new Properties());

               StringWriter writer = new StringWriter();
               if ( engine.evaluate(model, writer, "JNDIName", jndiNameTemplate) ) {
                  jndiName = writer.toString();
               }
               else {
                  jndiName = "Check velocity template " + jndiNameTemplate;
               }
            }
            catch (Exception e) {
               throw new RuntimeException(e);
            }

         }
      }
      return jndiName;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.j2ee.J2EEModelClass#isStateful()
    */
   public boolean isStateful() {
      boolean stateful = Boolean.valueOf(getStereotypeProperty(ModelStereotype.PROPERTY_STATEFUL, "false")).booleanValue();

      if ( !stateful && getSuperClass() != null ) {
         return ((J2EEModelClass) getSuperClass()).isStateful();
      }
      else {
         return stateful;
      }
   }

}
