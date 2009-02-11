/*
 *  $Header$
 *  Copyright (C) 2003, 2004, 2005 Dieter Moroff
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
 *  Created on 18.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.generator.model.uml;

import java.util.Collection;

/**
 * @author moroff
 */
public interface GeneratorModelElement {

   String getQualifiedName();
   
   /**
    * Non qualified name of a model element
    * @return
    */
   String getName();
   
   /**
    * Returns the generated name of the current model element
    * and current generated artefact
    * @return
    */
   public String getGeneratedName();

   /**
    * @return
    */
   Collection getStereotypes();

   /**
    * Returns the generator model containing the model element
    * @return
    */
   GeneratorModel getGeneratorModel();

   /**
    * Returns the name of the model element used in pattern replacement
    * @return
    */
   String getReplacementName();

   /**
    * Returns the documentation of the model element in the given 
    * generation context.
    * @see GeneratorContext
    */
   String getDocumentation(String context);
   
   void setAsCurrentArtefact(String artefact);
}
