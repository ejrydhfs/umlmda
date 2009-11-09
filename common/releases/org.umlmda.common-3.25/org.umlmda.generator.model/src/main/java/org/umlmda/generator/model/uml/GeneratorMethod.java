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
 *  Created on 21.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.generator.model.uml;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface GeneratorMethod extends GeneratorModelElement {

   /**
    * Returns the generated name of the current method and current generated artefact
    * @return
    */
   public String getGeneratedName();

   /**
    * Returns the generated name of the current method and given artefact
    * @param artefactName
    * @return
    */
   public String getGeneratedName(String artefactName);

   /**
    * Returns the generator class containing the methods
    * @return
    */
   public GeneratorClass getGeneratorClass();

   /**
    * Returns the method signature for the specific plattform
    * @return
    */
   String getSignature();
   
   /**
    * Returns the calling signature for the specific plattform
    */
   public String getCallSignature();

   /**
    * Returns the calling signature for the specific plattform, all 
    * parameters generated with an prefix
    */
   public String getCallSignature(String parameterPrefix);
   
   
}
