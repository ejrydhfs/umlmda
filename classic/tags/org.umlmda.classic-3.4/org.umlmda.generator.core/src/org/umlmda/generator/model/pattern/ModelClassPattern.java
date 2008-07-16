/*
 *   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/model/pattern/ModelClassPattern.java,v 1.1 2006/04/27 11:10:25 moroff Exp $
 *   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/model/pattern/ModelClassPattern.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2006/04/27 11:10:25 $
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
 * Created by Dieter Moroff (12.04.2006)
 */
package org.umlmda.generator.model.pattern;

import org.umlmda.model.uml.ModelClass;

/**
 * Pattern which replaces a model class 
 * @author Dieter Moroff (12.04.2006), last change $Date: 2006/04/27 11:10:25 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public interface ModelClassPattern {
   
   /**
    * Checks of the pattern is usable for the given model class
    * @param modelClass
    * @return <code>true</code> if pattern can be applies
    */
   public boolean isPatternFor(ModelClass modelClass);
   
   /**
    * Applies the pattern to the model class.
    * @param modelClass 
    * @return 
    */
   public ModelClass apply(ModelClass modelClass);
   
}