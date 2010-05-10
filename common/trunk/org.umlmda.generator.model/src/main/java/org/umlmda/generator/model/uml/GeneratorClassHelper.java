/*
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
 *  Created on 21.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.generator.model.uml;

import org.umlmda.generator.model.util.GeneratorUtils;

/**
 * @author MOROFF
 */
public class GeneratorClassHelper
{
   private final GeneratorClass genClass;

   /**
    * 
    */
   public GeneratorClassHelper(GeneratorClass genClass) {
      super();
      this.genClass = genClass;
   }

   /**
    * Returns the generated name of the current class and current generated artefact
    * 
    * @return
    */
   public String getGeneratedName() {
      return getGeneratedName(genClass.getGeneratorModel().getContext().getCurrentArtefact().getName());
   }

   /**
    * Returns the generated name of the current class and the given artefact
    * 
    * @param string
    * @return
    */
   public String getGeneratedName(String artefactType) {
      return GeneratorUtils.getGeneratedName(genClass, artefactType);
   }

}
