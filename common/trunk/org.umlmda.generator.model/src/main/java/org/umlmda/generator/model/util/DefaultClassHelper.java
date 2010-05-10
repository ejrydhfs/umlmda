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
 *  Created on 22.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.generator.model.util;

import org.umlmda.model.uml.ModelDataType;

/**
 * @author MOROFF
 */
public class DefaultClassHelper extends AbstractClassHelper
{

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getType(org.umlmda.model.uml.ModelDataType)
    */
   public String getType(ModelDataType type) {
      return type.getName();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getNamespaceSep()
    */
   public String getNamespaceSep() {
      return "::";
   }

}
