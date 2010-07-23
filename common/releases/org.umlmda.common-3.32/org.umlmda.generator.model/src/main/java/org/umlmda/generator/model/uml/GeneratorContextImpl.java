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
 *  Created on 17.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.generator.model.uml;

import org.umlmda.generator.profile.Artefact;

/**
 * Implementation of the generator context
 */
public class GeneratorContextImpl implements GeneratorContext
{
   private GeneratorModelElement currentModelElement      = null;
   private Artefact              currentGeneratorArtefact = null;

   /**
    * 
    */
   public GeneratorContextImpl() {
      super();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorContext#getCurrentModelElement()
    */
   public GeneratorModelElement getCurrentModelElement() {
      return currentModelElement;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorContext#setCurrentModelElement(net.sourceforge.umlmda.xmi.uml.ModelElement)
    */
   public void setCurrentModelElement(GeneratorModelElement currentModelElement) {
      this.currentModelElement = currentModelElement;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorContext#getCurrentArtefact()
    */
   public Artefact getCurrentArtefact() {
      return currentGeneratorArtefact;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorContext#setCurrentArtefact(org.umlmda.uml.generator.GeneratorArtefact)
    */
   public void setCurrentArtefact(Artefact currentGeneratorArtefact) {
      this.currentGeneratorArtefact = currentGeneratorArtefact;
   }

}
