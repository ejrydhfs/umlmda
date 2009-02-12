/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/emf/EMFModelPackageAdapter.java,v 1.1 2007/01/03 21:15:54 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/emf/EMFModelPackageAdapter.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2007/01/03 21:15:54 $
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
 * Created on 04.12.2006 (Dieter Moroff)
 */
package org.umlmda.uml.generator.emf;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.impl.ModelDependencyImpl;
import org.umlmda.model.uml.impl.ModelPackageImpl;
import org.umlmda.uml.generator.webservices.WSModelPackage;
import org.umlmda.uml.generator.webservices.WSModelPackageAdapter;
import org.umlmda.uml.generator.webservices.WSStereotypes;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EMFModelPackageAdapter extends WSModelPackageAdapter {

   /**
    * @param modelPackage
    * @param model
    */
   EMFModelPackageAdapter(ModelPackageBase modelPackage, Model model) {
      super(modelPackage, model);
   }

   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelPackageAdapter#getReplacedName()
    */
   protected String getReplacedName() {
      return getName();
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelPackageAdapter#getReplacedQualifiedName()
    */
   protected String getReplacedQualifiedName() {
      return "emf" + "." + getQualifiedName();
   }
}
