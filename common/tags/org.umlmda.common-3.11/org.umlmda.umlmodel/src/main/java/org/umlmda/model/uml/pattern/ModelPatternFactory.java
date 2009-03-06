/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/pattern/ModelPatternFactory.java,v 1.1 2006/05/04 15:16:30 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/pattern/ModelPatternFactory.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2006/05/04 15:16:30 $
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
 * Created by Dieter Moroff (28.04.2006)
 */
package org.umlmda.model.uml.pattern;

import java.util.List;

/**
 * Pattern which replaces a model element with one or more other elements
 * or modifies an existing element on a pim model.
 * @author Dieter Moroff (28.04.2006), last change $Date: 2006/05/04 15:16:30 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public interface ModelPatternFactory {

   /**
    * Creates a list of model patterns to be applies on the pim model
    * @return
    */
   List createPatterns();
}
